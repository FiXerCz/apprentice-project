package com.hella.apprentice.project.logic;

import com.hella.apprentice.project.pojos.Hero;
import com.hella.apprentice.project.pojos.HeroRanking;
import com.hella.apprentice.project.utils.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TournamentTest {

    List<Hero> heroes;

    @BeforeEach
    public void setup() {
        Hero hero1 = new Hero.HeroBuilder().setName("Hero 1").setHp(10).build();
        Hero hero2 = new Hero.HeroBuilder().setName("Hero 2").setHp(10).build();
        Hero hero3 = new Hero.HeroBuilder().setName("Hero 3").setHp(10).build();
        Hero hero4 = new Hero.HeroBuilder().setName("Hero 4").setHp(10).build();
        heroes = new ArrayList<>();
        heroes.addAll(Arrays.asList(hero1, hero2, hero3, hero4));
    }

    @Test
    void getInstance() {
        Assertions.assertNotNull(Tournament.getInstance());
        Assertions.assertEquals(Tournament.getInstance().hashCode(), Tournament.getInstance().hashCode());
    }

    @Test
    void startTournamentWrongParam() {
        try {
            Tournament.getInstance().startTournament(null);
            fail();
        } catch (Exception e) {}

        try {
            Tournament.getInstance().startTournament(new ArrayList<>());
            fail();
        } catch (Exception e) {}

        try {
            Tournament.getInstance().startTournament(List.of(new Hero.HeroBuilder().build()));
            fail();
        } catch (Exception e) {}

        try {
            Tournament.getInstance().startTournament(List.of(new Hero.HeroBuilder().build(), new Hero.HeroBuilder().build(), new Hero.HeroBuilder().build()));
            fail();
        } catch (Exception e) {}

        try {
            Tournament.getInstance().startTournament(List.of(new Hero.HeroBuilder().build(), new Hero.HeroBuilder().build()));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    void startTournament() {
        Tournament.getInstance().startTournament(heroes);
        Assertions.assertTrue(Tournament.getInstance().isStarted());
        Assertions.assertFalse(Tournament.getInstance().isFinished());
        Assertions.assertTrue(Tournament.getInstance().getRounds().isEmpty());
        Assertions.assertEquals(4, Tournament.getInstance().getRankings().size());
        Tournament.getInstance().getRankings().forEach(heroRanking -> Assertions.assertEquals(0, heroRanking.getPoints()));
        Tournament.getInstance().getRankings().forEach(heroRanking -> Assertions.assertNotNull(heroRanking.getHero()));
        Tournament.getInstance().getRankings().forEach(heroRanking -> Assertions.assertTrue(heroes.contains(heroRanking.getHero())));
        Assertions.assertEquals(Tournament.getInstance().getPlayers().size(), heroes.size());
        heroes.remove(3);
        Assertions.assertNotEquals(Tournament.getInstance().getPlayers(), heroes);
    }

    @Test
    void getRemainingHeroes() {
        Tournament.getInstance().startTournament(heroes);
        Assertions.assertEquals(4, Tournament.getInstance().getRemainingHeroes().size());
        Tournament.getInstance().getPlayers().get(0).receiveDamage(100);
        Assertions.assertEquals(3, Tournament.getInstance().getRemainingHeroes().size());
    }

    @Test
    void addRound() {
        Tournament.getInstance().startTournament(heroes);
        Round round = Tournament.getInstance().addRound();
        Assertions.assertNotNull(round);
        Assertions.assertEquals(1, Tournament.getInstance().getRounds().size());
        Assertions.assertFalse(round.isFinished());
    }

    @Test
    void addPoints() {
        Tournament.getInstance().startTournament(heroes);
        Hero selectedHero = heroes.get(0);
        HeroRanking ranking = Tournament.getInstance().getRankings().stream()
                .filter(heroRanking -> heroRanking.getHero().equals(selectedHero))
                .collect(Collectors.toList())
                .get(0);
        Assertions.assertEquals(0, ranking.getPoints());
        Tournament.getInstance().addPoints(heroes.get(0));
        Assertions.assertEquals(Constants.POINTS_FOR_WIN, ranking.getPoints());
    }
}
