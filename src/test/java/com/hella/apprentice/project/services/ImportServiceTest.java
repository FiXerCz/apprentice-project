package com.hella.apprentice.project.services;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ImportServiceTest {

    @Inject ImportService importService;
    @Inject HeroService heroService;

    @Test
    public void importHeroesFromFileTest() {
        int heroesBeforeImport = heroService.countAllHeroes();
        int numberOfImportedHeroes = importService.importHeroesFromFile();
        assertEquals(heroesBeforeImport+numberOfImportedHeroes,heroService.countAllHeroes());
    }

}
