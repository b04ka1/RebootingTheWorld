package net.max_di.rtw.common.entity.gingerbread.gingerbread_man.ai;

import net.max_di.rtw.common.entity.gingerbread.gingerbread_man.GingerbreadManEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;

import java.util.EnumSet;
import java.util.UUID;

public class OwnerHurtTarget extends TargetGoal {
    private final GingerbreadManEntity entity;
    private LivingEntity ownerLastHurt;
    private int timestamp;

    public OwnerHurtTarget(GingerbreadManEntity pTameAnimal) {
        super(pTameAnimal, false);
        this.entity = pTameAnimal;
        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
    }

    @Override
    public boolean canUse() {
        if (this.entity.hasStick()) {
            LivingEntity livingentity = getOwner();
            if (livingentity == null) {
                return false;
            } else {
                this.ownerLastHurt = livingentity.getLastHurtMob();
                int i = livingentity.getLastHurtMobTimestamp();
                return i != this.timestamp
                        && this.canAttack(this.ownerLastHurt, TargetingConditions.DEFAULT);
            }
        } else {
            return false;
        }
    }

    @Override
    public void start() {
        this.mob.setTarget(this.ownerLastHurt);
        LivingEntity livingentity = getOwner();
        if (livingentity != null) {
            this.timestamp = livingentity.getLastHurtMobTimestamp();
        }

        super.start();
    }

    private Player getOwner() {
        UUID uuid = this.entity.getOwnerUUID();
        if (uuid != null) {
            return this.entity.level().getPlayerByUUID(uuid);
        } else {
            this.stop();
            return null;
        }
    }
}
