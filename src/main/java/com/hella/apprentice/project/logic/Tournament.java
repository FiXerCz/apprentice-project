package com.hella.apprentice.project.logic;

import com.hella.apprentice.project.pojos.Hero;
import com.hella.apprentice.project.pojos.HeroRanking;
import com.hella.apprentice.project.utils.Constants;
import com.hella.apprentice.project.utils.Utils;
import org.jboss.resteasy.reactive.common.NotImplementedYet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tournament {

    private static Tournament INSTANCE;

    private boolean started;

    private List<Round> rounds;
    private List<Hero> players;
    private List<HeroRanking> rankings;

    private final Conflict conflict = new Conflict();

    private Tournament() {
        // private constructor - Singleton design pattern
    }

    /**
     * Implement singleton design pattern. Work with existing class attribute INSTANCE.
     *
     * Hint: https://www.baeldung.com/java-singleton#singleton
     *
     * @return
     */
    public static Tournament getInstance() {
        throw new NotImplementedYet();
    }

    /**
     * Start and setup a new game.
     *
     * Copy <param>heroes</param> to the <attribute>players</attribute>.
     * Initialise <attribute>rounds</attribute> with empty list.
     * Initalise <attribute>rankings</attribute> with list of HeroRanking objects for every Hero
     * from <attribute>players</attribute>. Every Hero should start with 0 points in the ranking.
     *
     * @throws IllegalStateException - if there are no players, only 1 player or the number of players is not power of
     * two (for last condition just call Utils.isPowerOfTwo(heroes.size()))
     *
     * @param heroes
     */
    public void startTournament(List<Hero> heroes) {
        throw new NotImplementedYet();
    }

    /**
     * Return heroes from <atribute>players</atribute> who are still alive.
     * @return
     */
    public List<Hero> getRemainingHeroes() {
        throw new NotImplementedYet();
    }

    /**
     * Add a new round to the <attribute>rounds</attribute> list. The added round should have only those players from
     * <attribute>players</attribute> list, who are alive (use existing method for selecting those).
     *
     * If the game is not started, the method should throw IllegalStateException.
     *
     * @return
     */
    public Round addRound() {
        throw new NotImplementedYet();
    }

    /**
     * Add points (use constant value Constants.POINTS_FOR_WIN) in the hero ranking for the passed <param>winner</param>.
     * If the game is not started, the method should throw IllegalStateException.
     *
     *
     * @throws IllegalStateException if the game is not started
     * @param winner
     */
    public void addPoints(Hero winner) {
        throw new NotImplementedYet();
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public List<Hero> getPlayers() {
        return players;
    }

    public List<HeroRanking> getRankings() {
        return rankings;
    }

    public boolean isStarted() {
        return started;
    }

    public boolean isFinished() {
        return started
                && rounds.size() == Utils.expectedNumberOfRounds(players.size())
                && rounds.stream().allMatch(r -> r.isFinished());
    }

    public Conflict getConflict() {
        return conflict;
    }

}
