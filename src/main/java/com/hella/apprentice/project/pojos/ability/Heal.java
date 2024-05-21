package com.hella.apprentice.project.pojos.ability;

import com.hella.apprentice.project.enums.AbilityTarget;
import com.hella.apprentice.project.pojos.Hero;

public class Heal implements AbilityInterface {

    public static final int AMOUNT_OF_HP_HEALED = 7;

    private final int cooldown = 3;
    private int currentCooldown = 0;

    @Override
    public boolean isReady() {
        return currentCooldown==0;
    }

    @Override
    public String getName() {
        return "HEAL";
    }

    @Override
    public void decreaseCooldown() {
        if (currentCooldown>0) {
            currentCooldown--;
        }
    }

    @Override
    public void triggerAction(Hero target) {
        if (target!=null && isReady()) {
            target.addHp(AMOUNT_OF_HP_HEALED);
            putAbilityOnCooldown();
        }
    }

    @Override
    public void putAbilityOnCooldown() {
        currentCooldown = cooldown;
    }

    @Override
    public AbilityTarget getTargetOfAbility() {
        return AbilityTarget.SELF;
    }

    @Override
    public boolean makeSenseToUse(Hero target) {
        return target.getMaxHp() - target.getCurrentHp() > AMOUNT_OF_HP_HEALED;
    }
}
