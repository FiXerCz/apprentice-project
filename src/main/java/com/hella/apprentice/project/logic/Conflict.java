package com.hella.apprentice.project.logic;

import com.hella.apprentice.project.enums.AbilityTarget;
import com.hella.apprentice.project.exceptions.InvalidDuelException;
import com.hella.apprentice.project.pojos.Hero;
import com.hella.apprentice.project.pojos.ability.AbilityInterface;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.common.NotImplementedYet;


public class Conflict {

    private static final Logger LOG = Logger.getLogger(Conflict.class);

    /**
     * Attacker will cause damage on defender (defender will take damage)
     * Damage will be determined by attack power of the attacker.
     * @param attacker
     * @param defender
     */
    public void attack(Hero attacker, Hero defender) {
        throw new NotImplementedYet();
    }

    /**
     * Owner has an ability assigned. Determine, whether ability will be applied to the owner or the enemy.
     * @param owner
     * @param enemy
     * @return owner or enemy (depending on who will the ability applied)
     */
    public Hero evaluateTargetOfAbility(Hero owner, Hero enemy) {
        throw new NotImplementedYet();
    }

    /**
     * <param>attacker</param> makes an action. Action is either attacking of the second hero or using the ability (if
     * hero has ability and ability is ready. Use existing methods from this class.
     * @param attacker
     * @param defender
     */
    public void doAction(Hero attacker, Hero defender) {
        throw new NotImplementedYet();
    }

    /**
     * Heroes take turn and make their moves until one of them dies. Move can be an attack or ability usage. Use
     * existing methods from this class.
     * <param>firsthero</param> always starts.
     * @param firstHero
     * @param secondHero
     * @return Hero who won
     * @throws InvalidDuelException if any of the input parameters in null
     */
    public Hero fight(Hero firstHero, Hero secondHero) throws InvalidDuelException {
        throw new NotImplementedYet();
    }

}
