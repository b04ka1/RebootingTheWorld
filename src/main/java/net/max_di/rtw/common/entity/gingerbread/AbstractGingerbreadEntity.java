package net.max_di.rtw.common.entity.gingerbread;

import net.max_di.rtw.common.entity.gingerbread.ai.FollowPlayerGoal;
import net.max_di.rtw.common.entity.gingerbread.ai.WaitGoal;
import net.max_di.rtw.common.utils.ModSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.JukeboxBlock;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public abstract class AbstractGingerbreadEntity extends Animal {
    protected static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(AbstractGingerbreadEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> COMMAND =
            SynchedEntityData.defineId(AbstractGingerbreadEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DANCE_ID =
            SynchedEntityData.defineId(AbstractGingerbreadEntity.class, EntityDataSerializers.INT);
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitAnimationState = new AnimationState();
    public final AnimationState standUpAnimationState = new AnimationState();
    protected int idleAnimationTimeout = 0;
    protected int sitAnimationTimeout = 0;
    protected int danceAnimationTimeout = 0;
    protected final int idleAnimationLength;
    protected final int sitAnimationLength;
    protected final int sitDownAnimationLength;

    protected AbstractGingerbreadEntity(EntityType<? extends Animal> pEntityType, Level pLevel, int idleAnimationLength, int sitAnimationLength, int sitDownAnimationLength) {
        super(pEntityType, pLevel);
        this.idleAnimationLength = idleAnimationLength;
        this.sitAnimationLength = sitAnimationLength;
        this.sitDownAnimationLength = sitDownAnimationLength;
    }

    @Override
    public void tick() {
        super.tick();
        if (level().isClientSide()) {
            if (getCommand() < 2) {
                //For overriding
                idleTick();
            } else if (getCommand() == 2) {
                if (this.sitAnimationTimeout <= 0) {
                    this.sitDownAnimationState.stop();
                    this.sitAnimationTimeout = this.sitAnimationLength;
                    this.sitAnimationState.start(this.tickCount);
                } else {
                    --this.sitAnimationTimeout;
                }
            }
        }
        if (getCommand() == 3) {
            if (this.danceAnimationTimeout <= 0) {
                for (AnimationState dance : this.getDanceAnimationsMap().keySet()) {
                    if (this.getDanceAnimationsMap().keySet().stream().toList().indexOf(dance) == getDanceID()) {
                        this.danceAnimationTimeout = this.getDanceAnimationsMap().get(dance);
                        dance.start(this.tickCount);
                        break;
                    }
                }
                if (!checkJukebox()) {
                    setCommand(0);
                    this.idleAnimationTimeout = 0;
                }
            } else {
                --this.danceAnimationTimeout;
            }
        }
    }

    protected void idleTick() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.idleAnimationLength;
            this.getDanceAnimationsMap().keySet().forEach(AnimationState::stop);
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (hand == InteractionHand.MAIN_HAND) {
            if (player.isShiftKeyDown()) {
                remove(RemovalReason.KILLED);
                if (level() instanceof ServerLevel serverlevel) {
                    this.dropAllDeathLoot(serverlevel, damageSources().genericKill());
                    double offsetX = random.nextGaussian() * 0.02D;
                    double offsetY = random.nextGaussian() * 0.02D;
                    double offsetZ = random.nextGaussian() * 0.02D;
                    for (int i = 0; i < 20; i++) {
                        serverlevel.sendParticles(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), 1, offsetX, offsetY, offsetZ, 0.1);
                    }
                    this.playSound(SoundEvents.FIRE_EXTINGUISH, 1.0F, 1.0F);
                }
                return InteractionResult.sidedSuccess(this.level().isClientSide());
            } else {
                if (canUpdateCommand()) {
                    setCommand(getCommand() + 1);
                    switch (getCommand()) {
                        case 2:
                            this.idleAnimationState.stop();
                            this.sitDownAnimationState.start(this.tickCount);
                            this.sitAnimationTimeout = sitDownAnimationLength;
                            break;
                        case 3:
                            this.sitDownAnimationState.stop();
                            this.sitAnimationState.stop();
                            this.standUpAnimationState.start(this.tickCount);
                            this.danceAnimationTimeout = 0;
                            this.idleAnimationTimeout = 0;
                            setDanceID(random.nextInt(getDanceAnimationsMap().size()));
                            if (!checkJukebox()) setCommand(0);
                            break;
                        case 4:
                            setCommand(0);
                            this.getDanceAnimationsMap().keySet().forEach(AnimationState::stop);
                            break;
                        default:
                            break;
                    }
                    player.displayClientMessage(Component.translatable("entity.rtw.all.command_" + this.getCommand(), this.getName()), true);
                    return InteractionResult.sidedSuccess(this.level().isClientSide());
                }
            }
        }
        return super.mobInteract(player, hand);
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new WaitGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(3, new FollowPlayerGoal(this, 1.1D, 4.0F));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(Items.DRAGON_EGG), false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return false;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(VARIANT, 0);
        pBuilder.define(COMMAND, 0);
        pBuilder.define(DANCE_ID, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pTag) {
        super.addAdditionalSaveData(pTag);
        pTag.putInt("Variant", this.getTypeVariant());
        pTag.putInt("Command", this.getCommand());
        pTag.putInt("DanceID", this.getDanceID());

    }

    @Override
    public void readAdditionalSaveData(CompoundTag pTag) {
        super.readAdditionalSaveData(pTag);
        this.entityData.set(VARIANT, pTag.getInt("Variant"));
        setCommand(pTag.getInt("Command"));
        setDanceID(pTag.getInt("DanceID"));
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSounds.GINGERBREAD_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.GINGERBREAD_HURT.get();
    }

    public int getCommand() {
        return this.entityData.get(COMMAND);
    }

    public void setCommand(int command) {
        this.entityData.set(COMMAND, command);
    }

    public int getDanceID() {
        return this.entityData.get(DANCE_ID);
    }

    public void setDanceID(int id) {
        this.entityData.set(DANCE_ID, id);
    }

    protected int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public boolean isFollowingPlayer() {
        return this.entityData.get(COMMAND) == 1;
    }

    public boolean checkJukebox() {
        int radius = 5;
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    if (this.level().getBlockState(this.blockPosition().offset(x, y, z)) ==
                            Blocks.JUKEBOX.defaultBlockState().setValue(JukeboxBlock.HAS_RECORD, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return createMobAttributes()
                .add(Attributes.MAX_HEALTH, 6)
                .add(Attributes.MOVEMENT_SPEED, 0.2D)
                .add(Attributes.FOLLOW_RANGE, 24);
    }

    protected abstract Map<AnimationState, Integer> getDanceAnimationsMap();

    //For overriding
    protected boolean canUpdateCommand() {
        return true;
    }
}
