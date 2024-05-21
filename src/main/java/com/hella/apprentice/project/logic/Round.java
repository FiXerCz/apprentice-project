package com.hella.apprentice.project.logic;

import com.hella.apprentice.project.exceptions.InvalidDuelException;
import com.hella.apprentice.project.pojos.Duel;
import com.hella.apprentice.project.pojos.Hero;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.common.NotImplementedYet;

import java.util.*;

public class Round {

    private static final Logger LOG = Logger.getLogger(Round.class);

    // all players in this round
    private final List<Hero> playersInRound;

    // pairs of player who will fight against each other
    private final List<Duel> opponents;

    private boolean finished;

    public Round(List<Hero> playersInRound) {
        if (playersInRound == null || playersInRound.isEmpty() || playersInRound.size() % 2 != 0) {
            throw new IllegalStateException("Round must have a number of opponents divisible by 2");
        }

        this.playersInRound = playersInRound;
        this.opponents = prepareOpponents();
    }

    /**
     * Create pairs of heroes, who will fight each other (Duel.java).
     * Pairs are created from all players in the round. Pairs should be created at random.
     *
     * Hint 1: Collections.shuffle()
     *
     * Hint 2: for (int i = 0; i < totalNumberOfHeroes; i + 2)
     *
     * @return List<Duel>
     */
    public List<Duel> prepareOpponents() {
        throw new NotImplementedYet();
    }

    /**
     * Go over all opponent pairs we have and have each pair fight each other.
     * Don't forget to set the winner of the duel, restore winner's HP and update score of the hero in tournament.
     * At the end mark this round as finished.
     *
     * Hint: Tournament.getInstance() - get access to Conflict class and tournament ranking
     *
     */
    public void playRound() {
        throw new NotImplementedYet();
    }

    public boolean isFinished() {
        return finished;
    }

    public List<Duel> getOpponents() {
        return opponents;
    }

    public List<Hero> getPlayersInRound() {
        return playersInRound;
    }
}
