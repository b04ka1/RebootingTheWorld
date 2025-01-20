package net.max_di.rtw.common.entity.dynamite_stick;

import net.max_di.rtw.common.entity.ModEntities;
import net.max_di.rtw.common.entity.spike.SpikeEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;


public class ThrownDynamiteStickEntity extends ThrowableItemProjectile {
    private static final EntityDataAccessor<Boolean> IS_SPIKY = SynchedEntityData.defineId(ThrownDynamiteStickEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> EXPLOSION_LEVEL = SynchedEntityData.defineId(ThrownDynamiteStickEntity.class, EntityDataSerializers.INT);


    public ThrownDynamiteStickEntity(EntityType pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.fixupDimensions();
    }

    public ThrownDynamiteStickEntity(Level pLevel, LivingEntity pShooter) {
        super(ModEntities.THROWN_DYNAMITE_STICK.get(), pShooter, pLevel);
        this.fixupDimensions();
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide()) {
            this.remove(RemovalReason.KILLED);
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), getExplosionLevel(), Level.ExplosionInteraction.TNT);
            if (getSpiky()) {
                float size = getExplosionLevel();
                float speed = 0.35F + (getExplosionLevel() * 0.03F);
                for (float i = 0; i <= size; i++) {
                    for (float j = -size; j <= size; j++) {
                        for (float k = -size; k <= size; k++) {
                            double offsetX = j + (random.nextDouble() - random.nextDouble());
                            double offsetY = i + (random.nextDouble() - random.nextDouble());
                            double offsetZ = k + (random.nextDouble() - random.nextDouble());
                            double scale = Mth.sqrt((float) (offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ)) / speed + random.nextGaussian();
                            Vec3 motion = new Vec3(offsetX / scale, offsetY / scale, offsetZ / scale);
                            float mul = this.getBbHeight() / 1.5F;
                            Vec3 pos = this.position().add(0, mul, 0).add(motion.normalize().multiply(mul, mul, mul));
                            SpikeEntity spike = new SpikeEntity(level(), this.getX(), this.getY(), this.getZ());
                            spike.setOwner(this);
                            spike.setPos(pos);
                            spike.setDeltaMovement(motion);
                            level().addFreshEntity(spike);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected Item getDefaultItem() {
        return Items.APPLE;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(IS_SPIKY, false);
        pBuilder.define(EXPLOSION_LEVEL, 1);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("IsSpiky", getSpiky());
        pCompound.putInt("ExplosionLevel", getExplosionLevel());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        setSpiky(pCompound.getBoolean("IsSpiky"));
        setExplosionLevel(pCompound.getInt("ExplosionLevel"));
    }

    @Override
    public EntityDimensions getDimensions(Pose pPose) {
        if (getExplosionLevel() <= 1) {
            return EntityDimensions.scalable(0.3f, 0.7f);
        } else if (getExplosionLevel() <= 2) {
            return EntityDimensions.scalable(0.5f, 0.7f);
        } else {
            return EntityDimensions.scalable(0.8f, 0.8f);
        }
    }

    @Override
    protected AABB makeBoundingBox() {
        return this.getDimensions(this.getPose()).makeBoundingBox(this.position());
    }

    public boolean getSpiky() {
        return this.entityData.get(IS_SPIKY);
    }

    public void setSpiky(boolean value) {
        this.entityData.set(IS_SPIKY, value);
    }

    public int getExplosionLevel() {
        return this.entityData.get(EXPLOSION_LEVEL);
    }

    public void setExplosionLevel(int value) {
        this.entityData.set(EXPLOSION_LEVEL, value);
    }

    public ThrownDynamiteStickVariant getStickVariant() {
        if (!getSpiky()) {
            if (getExplosionLevel() <= 1) {
                return ThrownDynamiteStickVariant.SINGLE;
            } else if (getExplosionLevel() <= 2) {
                return ThrownDynamiteStickVariant.QUADRUPLE;
            } else {
                return ThrownDynamiteStickVariant.NINE_BY_NINE;
            }
        } else {
            if (getExplosionLevel() <= 1) {
                return ThrownDynamiteStickVariant.SINGLE_SPIKY;
            } else if (getExplosionLevel() <= 2) {
                return ThrownDynamiteStickVariant.QUADRUPLE_SPIKY;
            } else {
                return ThrownDynamiteStickVariant.NINE_BY_NINE_SPIKY;
            }
        }
    }

    public static void explode(int explosionLevel, boolean spiky) {
    }
}
