package com.hella.apprentice.project.pojos;

import com.hella.apprentice.project.enums.Race;
import com.hella.apprentice.project.pojos.ability.AbilityInterface;

public interface HeroInterface {

    String getName();

    Race getRace();

    int getMaxHp();

    int getCurrentHp();

    int getAttack();

    int getDefense();

    int receiveDamage(int damage);

    void refreshCurrentHp();

    void addHp(int hp);

    boolean hasAbility();

    AbilityInterface getAbility();

    boolean isAlive();

}
