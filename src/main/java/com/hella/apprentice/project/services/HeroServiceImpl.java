package com.hella.apprentice.project.services;

import com.hella.apprentice.project.enums.Race;
import com.hella.apprentice.project.pojos.Hero;
import org.jboss.resteasy.reactive.common.NotImplementedYet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Named
@ApplicationScoped
public class HeroServiceImpl implements HeroService {

    /**
     * This is holder for our heroes. This collection should contain all existing heroes.
     * Please be sure, that if you need work with this collection, you will obtain copy of that data.
     * @see HeroServiceImpl#getHeroesCopyAsList() for obtain list copy
     * @see HeroServiceImpl#getHeroesCopyAsStream() for obtain stream copy
     */
    private final List<Hero> heroes = new ArrayList<>();

    @Override
    public void addHero(Hero hero) {
        throw new NotImplementedYet();
    }

    @Override
    public void removeHero(Hero hero) {
        throw new NotImplementedYet();
    }

    @Override
    public void removeHero(String name) {
        throw new NotImplementedYet();
    }

    @Override
    public Hero findByName(String name) {
        throw new NotImplementedYet();
    }

    @Override
    public List<Hero> getAllHeroes() {
        throw new NotImplementedYet();
    }

    @Override
    public List<Hero> getAllHeroesWithRace(Race race) {
        throw new NotImplementedYet();
    }

    @Override
    public int countAllHeroes() {
        throw new NotImplementedYet();
    }

    /**
     * Support method, which can be used to copy list of heroes.
     * If you obtain list in this way, then original data will not be corrupted.
     * @return list copy of heroes
     */
    private List<Hero> getHeroesCopyAsList() {
        return heroes.stream().map(Hero::new).collect(Collectors.toList());
    }

    /**
     * Support method, which can be used to copy list of heroes.
     * If you obtain list in this way, then original data will not be corrupted.
     * @return stream copy of heroes
     */
    private Stream<Hero> getHeroesCopyAsStream() {
        return heroes.stream().map(Hero::new);
    }

}
