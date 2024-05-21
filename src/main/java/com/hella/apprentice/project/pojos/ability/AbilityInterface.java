package com.hella.apprentice.project.pojos.ability;

import com.hella.apprentice.project.enums.AbilityTarget;
import com.hella.apprentice.project.pojos.Hero;

public interface AbilityInterface {

    boolean isReady();

    String getName();

    void decreaseCooldown();

    void triggerAction(Hero target);

    void putAbilityOnCooldown();

    AbilityTarget getTargetOfAbility();

    boolean makeSenseToUse(Hero target);
}
