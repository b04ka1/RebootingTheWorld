package net.max_di.rtw.common.entity.spike;

import net.max_di.rtw.common.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class SpikeEntity extends AbstractArrow {
    public SpikeEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SpikeEntity(Level pLevel, double pX, double pY, double pZ) {
        super(ModEntities.SPIKE.get(), pX, pY, pZ, pLevel, Items.APPLE.getDefaultInstance(), null);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return Items.APPLE.getDefaultInstance();
    }
}
