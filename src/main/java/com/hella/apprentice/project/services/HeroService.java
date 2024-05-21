package com.hella.apprentice.project.services;

import com.hella.apprentice.project.enums.Race;
import com.hella.apprentice.project.pojos.Hero;

import java.util.List;

public interface HeroService {

    /**
     * Method should take instance of Hero object and store it.
     * @param hero instance of hero
     */
    void addHero(Hero hero);

    /**
     * Method will try find and remove hero from storage. If here do not exist. It will ignore request.
     * @param hero instance of hero
     */
    void removeHero(Hero hero);

    /**
     * Method will search for hero with specific name in storage. if it found him, it will delete that hero.
     * Method should take case about uppercase and lowercase letters during the search.
     * @param name of hero which should be removed
     */
    void removeHero(String name);

    /**
     * Search for hero with name from parameter. Upper and lower letters should be considered.
     * @param name of hero
     * @return hero with given name as parameter
     */
    Hero findByName(String name);

    /**
     * Will obtain and return list of all heroes from storage.
     * @return list of all heroes from storage
     */
    List<Hero> getAllHeroes();

    /**
     * Method will take parameter {@link Race} ane return all heroes with this race from storage.
     * Return all heroes in case, that parameter race will be null.
     * @param race as parameter for search
     * @return list of heroes limited to selected race
     */
    List<Hero> getAllHeroesWithRace(Race race);

    /**
     * Method will count all heroes in storage and return result of that count.
     * @return amount of heroes
     */
    int countAllHeroes();


}
