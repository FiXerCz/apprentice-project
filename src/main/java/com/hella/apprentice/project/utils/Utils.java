package com.hella.apprentice.project.utils;

import com.hella.apprentice.project.pojos.Hero;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Random;

public class Utils {
    private final static Random random = new Random();

    public static int getRandomNumberBetween(int a, int b) {
        return random.nextInt(b-a) + a;
    }

    public static Hero getRandomHeroFromList(List<Hero> heroes) {
        if (heroes.size()==1) {
            // exception for single item collection
            return heroes.get(0);
        }
        return heroes.get(getRandomNumberBetween(0,heroes.size()-1));
    }

    public static File getResourceAsFileByResourceName(String resourceName) throws FileNotFoundException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(resourceName);
        if (url!=null) {
            try {
                return new File(url.toURI());
            } catch (URISyntaxException e) {
                throw new FileNotFoundException(e.getMessage());
            }
        }
        return null;
    }

    public static int expectedNumberOfRounds(int n) {
        return (int)(Math.log(n) / Math.log(2));
    }

    public static boolean isPowerOfTwo(int n) {
        return (int) Math.ceil(Math.log(n) / Math.log(2)) == (int) Math.floor(Math.log(n) / Math.log(2));
    }
}
