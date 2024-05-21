package com.hella.apprentice.project.pojos;

import com.hella.apprentice.project.pojos.ability.Heal;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class HealAbilityTest {

    private final Heal healAbility = new Heal();

    @Test
    public void healAbilityCheck() {

        // prepare wounded hero
        Hero woundedHero =  new Hero.HeroBuilder().setName("Ninja").setHp(20).setDefense(0).setAttack(3).build();
        woundedHero.receiveDamage(15);
        int woundedHeroCurrentHp = woundedHero.getCurrentHp();
        assertTrue(woundedHeroCurrentHp<woundedHero.getMaxHp());

        //check and use ability
        assertTrue(healAbility.isReady());
        healAbility.triggerAction(woundedHero);
        assertFalse(healAbility.isReady());
        assertTrue(woundedHero.getCurrentHp()>woundedHeroCurrentHp);

        // check cooldown behavior / heal has cooldown 3 turn
        healAbility.decreaseCooldown();
        healAbility.decreaseCooldown();
        healAbility.decreaseCooldown();
        assertTrue(healAbility.isReady());

    }





}
