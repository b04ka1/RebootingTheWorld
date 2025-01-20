package net.max_di.rtw.common.entity.gingerbread.gingerbread_man;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.entity.gingerbread.AbstractGingerbreadEntity;
import net.max_di.rtw.common.entity.gingerbread.ai.FollowPlayerGoal;
import net.max_di.rtw.common.entity.gingerbread.ai.WaitGoal;
import net.max_di.rtw.common.entity.gingerbread.gingerbread_man.ai.OwnerHurtTarget;
import net.max_di.rtw.common.entity.spike.SpikeEntity;
import net.max_di.rtw.common.items.custom.DynamiteStickItem;
import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class GingerbreadManEntity extends AbstractGingerbreadEntity {
    protected static final EntityDataAccessor<String> STICK =
            SynchedEntityData.defineId(GingerbreadManEntity.class, EntityDataSerializers.STRING);
    protected static final EntityDataAccessor<Optional<UUID>> DATA_OWNERUUID_ID =
            SynchedEntityData.defineId(GingerbreadManEntity.class, EntityDataSerializers.OPTIONAL_UUID);
    public final AnimationState dance1AnimationState = new AnimationState();


    public GingerbreadManEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel, 212, 150, 11);
    }

    @Override
    protected Map<AnimationState, Integer> getDanceAnimationsMap() {
        return Map.of(dance1AnimationState, 15);
    }

    @Override
    protected void idleTick() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = hasStick() ? 34 : this.idleAnimationLength;
            this.getDanceAnimationsMap().keySet().forEach(AnimationState::stop);
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (hand == InteractionHand.MAIN_HAND) {
            ItemStack itemStackInHand = player.getItemInHand(hand);
            if (itemStackInHand.getItem() instanceof DynamiteStickItem item) {
                if (getStick().equals("none")) {
                    if (!player.isCreative()) {
                        itemStackInHand.shrink(1);
                    }
                    this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, 1.0F);
                    this.sitDownAnimationState.stop();
                    this.sitAnimationState.stop();
                    this.idleAnimationTimeout = 0;
                    this.idleAnimationState.stop();
                    if (getCommand() == 2) this.standUpAnimationState.start(this.tickCount);
                    setCommand(0);
                    setStick(item.getNameId());
                    setOwnerUUID(player.getUUID());
                    return InteractionResult.sidedSuccess(level().isClientSide());
                } else {
                    return InteractionResult.PASS;
                }
            } else if (itemStackInHand.isEmpty() && hasStick()) {
                this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, 1.0F);
                if (!player.getInventory().add(new ItemStack(getStickById()))) {
                    player.drop(new ItemStack(getStickById()), false);
                }
                clearStick();
                return InteractionResult.sidedSuccess(level().isClientSide());
            }
        }
        return super.mobInteract(player, hand);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5D, false) {
            @Override
            protected void checkAndPerformAttack(LivingEntity pTarget) {
                if (this.canPerformAttack(pTarget)) {
                    ((GingerbreadManEntity) this.mob).explode();
                    this.stop();
                }
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && ((GingerbreadManEntity) this.mob).hasStick();
            }

            @Override
            protected boolean canPerformAttack(LivingEntity pEntity) {
                return super.canPerformAttack(pEntity) && ((GingerbreadManEntity) this.mob).hasStick();
            }
        });
        this.goalSelector.addGoal(2, new WaitGoal(this) {
            @Override
            public boolean canUse() {
                return super.canUse() || ((GingerbreadManEntity) this.entity).hasStick();
            }
        });
        this.goalSelector.addGoal(3, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(4, new FollowPlayerGoal(this, 1.1D, 4.0F));
        this.goalSelector.addGoal(5, new TemptGoal(this, 1.2D, Ingredient.of(Items.DRAGON_EGG), false));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(0, new OwnerHurtTarget(this));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pSpawnType,
                                        @Nullable SpawnGroupData pSpawnGroupData) {
        GingerbreadManVariant variant = Util.getRandom(GingerbreadManVariant.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
    }

    @Override
    public void onAddedToLevel() {
        super.onAddedToLevel();
        // Fixes crash with gingerbreads from older versions
        if (getStick().isEmpty()) {
            clearStick();
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pTag) {
        super.addAdditionalSaveData(pTag);
        pTag.putString("Stick", this.getStick());
        if (this.getOwnerUUID() != null) {
            pTag.putUUID("Owner", this.getOwnerUUID());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pTag) {
        super.readAdditionalSaveData(pTag);
        setStick(pTag.getString("Stick"));
        UUID uuid;
        if (pTag.hasUUID("Owner")) {
            uuid = pTag.getUUID("Owner");
        } else {
            String s = pTag.getString("Owner");
            uuid = OldUsersConverter.convertMobOwnerIfNecessary(this.getServer(), s);
        }

        if (uuid != null) {
            try {
                setOwnerUUID(uuid);
            } catch (Throwable ignored) {
            }
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(STICK, "none");
        pBuilder.define(DATA_OWNERUUID_ID, Optional.empty());
    }

    @Override
    protected void dropCustomDeathLoot(ServerLevel pLevel, DamageSource pDamageSource, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pLevel, pDamageSource, pRecentlyHit);
        if (hasStick()) {
            this.spawnAtLocation(getStickById());
        }
    }

    @Override
    protected boolean canUpdateCommand() {
        return !hasStick();
    }

    public GingerbreadManVariant getVariant() {
        return GingerbreadManVariant.byId(this.getTypeVariant() & 255);
    }

    public void setVariant(GingerbreadManVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    public String getStick() {
        return this.entityData.get(STICK);
    }

    public void setStick(String string) {
        this.entityData.set(STICK, string);
    }

    public void clearStick() {
        setStick("none");
    }

    public boolean hasStick() {
        return !getStick().equals("none");
    }

    public int getExplosionLevel() {
        if (!hasStick()) return 0;
        return Character.getNumericValue(getStick().charAt(0));
    }

    public boolean getSpiky() {
        if (!hasStick()) return false;
        if (getStick().length() < 2) return false;
        return getStick().charAt(1) == 's';
    }

    public UUID getOwnerUUID() {
        return this.entityData.get(DATA_OWNERUUID_ID).orElse(null);
    }

    public void setOwnerUUID(UUID pUuid) {
        this.entityData.set(DATA_OWNERUUID_ID, Optional.ofNullable(pUuid));
    }

    private void explode() {
        if (!this.level().isClientSide()) {
            this.kill();
            this.level().explode(this, this.getX(), this.getY() + 0.5, this.getZ(), getExplosionLevel(), Level.ExplosionInteraction.MOB);
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

    private Item getStickById() {
        String id = "";
        switch (getExplosionLevel()) {
            case 1:
                id = "small";
                break;
            case 2:
                id = "medium";
                break;
            case 3:
                id = "big";
                break;
        }
        if (getSpiky()) {
            id = id + "_spiky";
        }
        return BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, id + "_dynamite_stick"));
    }
}
