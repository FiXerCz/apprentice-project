package com.hella.apprentice.project.resources;

import com.hella.apprentice.project.services.HeroService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class HeroResourceTest {

    @Inject HeroService heroService;

    @Test
    public void testHelloEndpoint() {
        int amountOHeroes = heroService.countAllHeroes();
    }

}