package com.hella.apprentice.project.pojos;

import org.jboss.resteasy.reactive.common.NotImplementedYet;

/**
 * Implement Comparable for class attribute points: https://www.baeldung.com/java-comparator-comparable#comparable
 */
public class HeroRanking implements Comparable<HeroRanking> {

    private final Hero hero;
    private int points;

    public HeroRanking(Hero hero, int points) {
        this.hero = hero;
        this.points = points;
    }

    /**
     * Add points from method parameter to class attribute points.
     * @param points
     */
    public void addPoints(int points) {
        throw new NotImplementedYet();
    }

    public Hero getHero() {
        return hero;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public int compareTo(HeroRanking o) {
        return Integer.compare(points,o.getPoints());
    }

    @Override
    public String toString() {
        return "HeroRanking{" +
                "hero=" + hero.getName() +
                ", points=" + points +
                '}';
    }
}
