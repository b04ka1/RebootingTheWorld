package net.max_di.rtw.common.entity.gingerbread.gingerbread_creeper;

import net.max_di.rtw.common.effect.ModEffects;
import net.max_di.rtw.common.entity.gingerbread.AbstractGingerbreadEntity;
import net.minecraft.Util;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class GingerbreadCreeperEntity extends AbstractGingerbreadEntity {
    private static final EntityDataAccessor<Integer> BLOWING_UP_TIMEOUT =
            SynchedEntityData.defineId(GingerbreadCreeperEntity.class, EntityDataSerializers.INT);
    public final AnimationState blowUpAnimationState = new AnimationState();
    public final AnimationState dance1AnimationState = new AnimationState();
    public final AnimationState dance2AnimationState = new AnimationState();
    private int blowingUpAnimationTimeout = 0;


    public GingerbreadCreeperEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel, 60, 60, 18);
    }

    @Override
    protected Map<AnimationState, Integer> getDanceAnimationsMap() {
        return Map.of(dance1AnimationState, 40, dance2AnimationState, 266);
    }

    @Override
    public void tick() {
        super.tick();
        if (getBlowingUpTimeout() > 0) {
            setBlowingUpTimeout(getBlowingUpTimeout() - 1);
            if (level().isClientSide()) {
                blowingUpAnimationTimeout--;
                if (blowingUpAnimationTimeout <= 0) {
                    blowUpAnimationState.start(this.tickCount);
                    blowingUpAnimationTimeout = 10;
                }
            }
            if (getBlowingUpTimeout() <= 0) {
                this.level().addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY() + 0.5, this.getZ(), 1F, 0F, 0F);
                this.playSound(SoundEvents.GENERIC_EXPLODE.value());
                AreaEffectCloud areaeffectcloud = new AreaEffectCloud(level(), this.getX(), this.getY(), this.getZ());
                areaeffectcloud.setRadius(5.0F);
                areaeffectcloud.setRadiusOnUse(-0.5F);
                areaeffectcloud.setWaitTime(10);
                areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float) areaeffectcloud.getDuration());
                areaeffectcloud.addEffect(new MobEffectInstance(ModEffects.EFFECT_RESISTANCE, 600, 0));
                level().addFreshEntity(areaeffectcloud);
                setBlowingUpTimeout(0);
                if (level().isClientSide()) {
                    blowUpAnimationState.stop();
                }
            }
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (hand == InteractionHand.MAIN_HAND && player.getItemInHand(hand).getItem() == Items.MILK_BUCKET) {
            if (getBlowingUpTimeout() <= 0) {
                if (!player.isCreative()) {
                    player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                }
                this.playSound(SoundEvents.GENERIC_DRINK, 1.0F, 1.0F);
                this.playSound(SoundEvents.CREEPER_PRIMED, 1.0F, 0.5F);
                setBlowingUpTimeout(30);
                return InteractionResult.sidedSuccess(level().isClientSide());
            } else {
                return InteractionResult.PASS;
            }
        }
        return super.mobInteract(player, hand);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(BLOWING_UP_TIMEOUT, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pTag) {
        super.addAdditionalSaveData(pTag);
        pTag.putInt("BlowingUpTimeout", this.getBlowingUpTimeout());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pTag) {
        super.readAdditionalSaveData(pTag);
        setBlowingUpTimeout(pTag.getInt("BlowingUpTimeout"));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pSpawnType,
                                        @Nullable SpawnGroupData pSpawnGroupData) {
        GingerbreadCreeperVariant variant = Util.getRandom(GingerbreadCreeperVariant.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
    }

    public GingerbreadCreeperVariant getVariant() {
        return GingerbreadCreeperVariant.byId(this.getTypeVariant() & 255);
    }

    public void setVariant(GingerbreadCreeperVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    public int getBlowingUpTimeout() {
        return this.entityData.get(BLOWING_UP_TIMEOUT);
    }

    public void setBlowingUpTimeout(int timeout) {
        this.entityData.set(BLOWING_UP_TIMEOUT, timeout);
    }
}
