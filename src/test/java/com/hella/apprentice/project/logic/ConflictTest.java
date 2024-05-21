package com.hella.apprentice.project.logic;

import com.hella.apprentice.project.enums.Race;
import com.hella.apprentice.project.exceptions.InvalidDuelException;
import com.hella.apprentice.project.logic.Conflict;
import com.hella.apprentice.project.pojos.Hero;
import com.hella.apprentice.project.pojos.ability.AbilityInterface;
import com.hella.apprentice.project.pojos.ability.Heal;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ConflictTest {

    Conflict conflict = new Conflict();
    Hero orc;
    Hero human;

    @BeforeEach
    public void setup() {
        orc = new Hero.HeroBuilder()
                .setName("Orc")
                .setDefense(3)
                .setHp(20)
                .setAttack(5)
                .setRace(Race.Orc)
                .build();

        human = new Hero.HeroBuilder()
                .setName("Human")
                .setDefense(5)
                .setHp(20)
                .setAttack(4)
                .setRace(Race.Human)
                .setAbility(new Heal())
                .build();
    }

    @Test
    public void attackTest() throws InvalidDuelException {
        int currentOrc = orc.getCurrentHp();
        conflict.attack(human, orc);
        Assertions.assertTrue(orc.getCurrentHp() < currentOrc, "Orc did not take damage");
    }

    @Test
    public void abilityTest() throws InvalidDuelException {
        Hero target = conflict.evaluateTargetOfAbility(human, orc);
        Assertions.assertEquals(human, target, "Human is the target");
    }

    @Test
    public void actionTest() {
        // simple attack (orc without ability on human)
        int humanStartHp = human.getCurrentHp();
        conflict.doAction(orc, human);
        Assertions.assertTrue(humanStartHp > human.getCurrentHp());
        Assertions.assertEquals(human.getCurrentHp(), 17);
        conflict.doAction(orc, human);
        Assertions.assertEquals(human.getCurrentHp(), 14);

        // ability test
        conflict.doAction(human, orc);
        humanStartHp = human.getCurrentHp();
        Assertions.assertEquals(humanStartHp, human.getCurrentHp(), "Ability was not supposed to be used (makesense = false)");
        conflict.doAction(orc, human);
        humanStartHp = human.getCurrentHp();
        conflict.doAction(human, orc);
        Assertions.assertTrue(humanStartHp < human.getCurrentHp(), "Human should have healed himself");
    }

    @Test
    public void duelTest() throws InvalidDuelException {
        Assertions.assertTrue(orc.isAlive());
        Assertions.assertTrue(human.isAlive());
        conflict.fight(orc,human);
        Assertions.assertTrue(!orc.isAlive() || !human.isAlive());
    }

    @Test
    public void exceptionTest() {
        try {
            conflict.fight(null, orc);
            Assertions.fail("No exception thrown");
        } catch (InvalidDuelException e) {
        }

        try {
            conflict.fight(orc, null);
            Assertions.fail("No exception thrown");
        } catch (InvalidDuelException e) {
        }
    }


}
