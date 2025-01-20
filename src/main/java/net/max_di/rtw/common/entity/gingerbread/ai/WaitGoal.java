package net.max_di.rtw.common.entity.gingerbread.ai;

import net.max_di.rtw.common.entity.gingerbread.AbstractGingerbreadEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class WaitGoal extends Goal {
    protected final AbstractGingerbreadEntity entity;

    public WaitGoal(AbstractGingerbreadEntity entity) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return this.entity.getCommand() >= 2;
    }

    @Override
    public void start() {
        this.entity.getNavigation().stop();
    }

    @Override
    public void tick() {
        this.entity.getNavigation().stop();
    }
}