package com.hella.apprentice.project.services;

import com.hella.apprentice.project.enums.Race;
import com.hella.apprentice.project.pojos.Hero;
import com.hella.apprentice.project.pojos.ability.Heal;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HeroServiceTest {

    private static Hero orc;
    private static Hero human;
    private static Hero heroWithAbility;

    @Inject HeroService heroService;

    @BeforeAll
    static void init() {
        orc = new Hero.HeroBuilder().setName("SomeName").setAttack(5).setDefense(5).setHp(5).setRace(Race.Orc).build();
        Assertions.assertNotNull(orc);

        human = new Hero.HeroBuilder().setName("SomeOtherName").setAttack(5).setDefense(5).setHp(5).setRace(Race.Human).build();
        Assertions.assertNotNull(human);

        heroWithAbility = new Hero.HeroBuilder().setName("blah").setRace(Race.Undead).setDefense(5).setAttack(5).setHp(12).setAbility(new Heal()).build();
        Assertions.assertNotNull(heroWithAbility);
    }

    @Test
    @Order(1)
    public void addHeroTest() {
        assertEquals(0, heroService.countAllHeroes());
        heroService.addHero(orc);
        assertEquals(1, heroService.countAllHeroes());
        heroService.addHero(human);
        assertEquals(2, heroService.countAllHeroes());
    }

    @Test
    @Order(2)
    public void findByNameTest() {
        assertEquals(orc,heroService.findByName(orc.getName()));
        assertEquals(human,heroService.findByName(human.getName()));
    }

    @Test
    @Order(3)
    public void getAllHeroesTest() {
        assertEquals(2,heroService.getAllHeroes().size());
    }

    @Test
    @Order(4)
    public void getAllHeroesWithRaceTest() {
        assertEquals(1,heroService.getAllHeroesWithRace(Race.Human).size());
        assertEquals(1,heroService.getAllHeroesWithRace(Race.Orc).size());
    }

    @Test
    @Order(5)
    public void removeHeroTest() {
        assertEquals(1,heroService.getAllHeroesWithRace(Race.Orc).size());
        heroService.removeHero(orc);
        assertEquals(0,heroService.getAllHeroesWithRace(Race.Orc).size());
    }

    @Test
    @Order(6)
    public void removeHeroTest2() {
        assertEquals(1,heroService.getAllHeroesWithRace(Race.Human).size());
        heroService.removeHero(human.getName().toLowerCase(Locale.ROOT));
        assertEquals(0,heroService.getAllHeroesWithRace(Race.Human).size());
    }

    @Test
    @Order(7)
    public void hasAbilityTest() {
        Assertions.assertTrue(heroWithAbility.hasAbility());
    }

}
