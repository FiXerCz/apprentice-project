package com.hella.apprentice.project.pojos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroRankingTest {

    @Test
    void comparableTest() {
        HeroRanking r1 = new HeroRanking(null, 10);
        HeroRanking r2 = new HeroRanking(null, 20);
        HeroRanking r3 = new HeroRanking(null, 30);
        List<HeroRanking> list = Arrays.asList(r1, r2, r3);

        Collections.sort(list);
        Assertions.assertEquals(list, List.of(r1, r2, r3));

        r2.addPoints(20);
        Collections.sort(list);
        Assertions.assertEquals(list, List.of(r1, r3, r2));

        r1.addPoints(19);
        Collections.sort(list);
        Assertions.assertEquals(list, List.of(r1, r3, r2));

        r1.addPoints(2);
        Collections.sort(list);
        Assertions.assertEquals(list, List.of(r3, r1, r2));

        r2.addPoints(-11);
        Collections.sort(list);
        Assertions.assertEquals(list, List.of(r2, r3, r1));
    }

    @Test
    void addPoints() {
        HeroRanking ranking = new HeroRanking(null, 0);
        Assertions.assertEquals(0, ranking.getPoints());

        ranking.addPoints(10);
        Assertions.assertEquals(10, ranking.getPoints());

        ranking.addPoints(5);
        Assertions.assertEquals(15, ranking.getPoints());

        ranking.addPoints(-10);
        Assertions.assertEquals(5, ranking.getPoints());
    }
}
