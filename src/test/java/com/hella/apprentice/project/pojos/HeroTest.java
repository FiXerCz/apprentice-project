package com.hella.apprentice.project.pojos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void receiveDamage() {
        Hero hero = new Hero.HeroBuilder()
                .setDefense(5)
                .setHp(10).build();

        // damage less than defence, remainder after division
        int damage = hero.receiveDamage(5);
        Assertions.assertEquals(3, damage);
        Assertions.assertEquals(7, hero.getCurrentHp());

        // damage more than defence, remainder after division
        damage = hero.receiveDamage(7);
        Assertions.assertEquals(5, damage);
        Assertions.assertEquals(2, hero.getCurrentHp());

        damage = hero.receiveDamage(7);
        Assertions.assertEquals(5, damage);
        Assertions.assertEquals(0, hero.getCurrentHp(), "Can take negative damage");

        hero = new Hero.HeroBuilder()
                .setDefense(5)
                .setHp(20).build();

        // damage less than defence, no remainder after division
        damage = hero.receiveDamage(2);
        Assertions.assertEquals(1, damage);
        Assertions.assertEquals(19, hero.getCurrentHp());

        // damage more than defence, no remainder after division
        damage = hero.receiveDamage(9);
        Assertions.assertEquals(6, damage);
        Assertions.assertEquals(13, hero.getCurrentHp());
    }

    @Test
    void isAlive() {
        Assertions.assertFalse(new Hero.HeroBuilder().setHp(0).build().isAlive());
        Assertions.assertFalse(new Hero.HeroBuilder().setHp(-1).build().isAlive());
        Assertions.assertTrue(new Hero.HeroBuilder().setHp(1).build().isAlive());
    }

    @Test
    void refreshCurrentHp() {
        Hero hero = new Hero.HeroBuilder()
                .setDefense(5)
                .setHp(10).build();

        hero.receiveDamage(50);
        Assertions.assertNotEquals(10, hero.getCurrentHp());
        hero.refreshCurrentHp();
        Assertions.assertEquals(10, hero.getCurrentHp());
    }
}
