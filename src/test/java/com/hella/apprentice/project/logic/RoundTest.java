package com.hella.apprentice.project.logic;

import com.hella.apprentice.project.pojos.Duel;
import com.hella.apprentice.project.pojos.Hero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    Round r;
    List<Hero> heroes;

    @BeforeEach
    public void setup() {
        Hero hero1 = new Hero.HeroBuilder().setName("Hero 1").build();
        Hero hero2 = new Hero.HeroBuilder().setName("Hero 2").build();
        Hero hero3 = new Hero.HeroBuilder().setName("Hero 3").build();
        Hero hero4 = new Hero.HeroBuilder().setName("Hero 4").build();
        Hero hero5 = new Hero.HeroBuilder().setName("Hero 5").build();
        heroes = List.of(hero1, hero2, hero3, hero4, hero5);
        r = new Round(heroes.subList(0, 4));
    }

    @Test
    void constructorTest() {
        try {
            new Round(null);
            fail();
        } catch (Exception e) {}

        try {
            new Round(new ArrayList<>());
            fail();
        } catch (Exception e) {}

        try {
            new Round(heroes);
            fail();
        } catch (Exception e) {}

        try {
            new Round(heroes.subList(0, 4));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void prepareOpponents() {
        List<Duel> duels = r.prepareOpponents();
        Assertions.assertEquals(2, duels.size());
        r.getOpponents().forEach(duel -> Assertions.assertNull(duel.getWinner()));

        List<Hero> collect = duels.stream()
                .map(duel -> List.of(duel.getHero1(), duel.getHero2()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Assertions.assertEquals(collect.size(), r.getPlayersInRound().size());
        collect.forEach(hero -> r.getOpponents().contains(hero));
    }

    @Test
    void playRound() {
        Tournament.getInstance().startTournament(heroes.subList(0, 4));

        r.playRound();
        Assertions.assertTrue(r.isFinished());

        r.getOpponents().forEach(duel -> Assertions.assertTrue(!duel.getHero1().isAlive() || !duel.getHero2().isAlive()));
        r.getOpponents().forEach(duel -> Assertions.assertNotNull(duel.getWinner()));
        r.getOpponents().forEach(duel -> Assertions.assertEquals(duel.getWinner().getCurrentHp(), duel.getWinner().getMaxHp()));
    }
}
