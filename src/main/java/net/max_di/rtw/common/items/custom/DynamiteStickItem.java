package net.max_di.rtw.common.items.custom;

import net.max_di.rtw.common.entity.dynamite_stick.ThrownDynamiteStickEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DynamiteStickItem extends Item {
    private final int EXPLOSION_LEVEL;
    private final boolean IS_SPIKY;

    public DynamiteStickItem(Properties pProperties, int explosionLevel, boolean isSpiky) {
        super(pProperties.stacksTo(16));
        EXPLOSION_LEVEL = explosionLevel;
        IS_SPIKY = isSpiky;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pLevel.playSound(
                null,
                pPlayer.getX(),
                pPlayer.getY(),
                pPlayer.getZ(),
                SoundEvents.SNOWBALL_THROW,
                SoundSource.NEUTRAL,
                0.5F,
                0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        pPlayer.getCooldowns().addCooldown(this, 20);
        if (!pLevel.isClientSide) {
            ThrownDynamiteStickEntity stick = new ThrownDynamiteStickEntity(pLevel, pPlayer);
            stick.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            stick.setExplosionLevel(this.EXPLOSION_LEVEL);
            stick.setSpiky(this.IS_SPIKY);
            pLevel.addFreshEntity(stick);
        }
        itemstack.consume(1, pPlayer);
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

    public String getNameId() {
        String id;
        id = String.valueOf(this.EXPLOSION_LEVEL);
        if (this.IS_SPIKY) {
            id = id + "s";
        }
        return id;
    }


}
