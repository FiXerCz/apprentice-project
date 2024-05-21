package com.hella.apprentice.project.services;

import com.hella.apprentice.project.utils.Utils;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.wildfly.common.Assert.assertTrue;

@QuarkusTest
public class UtilsTest {

    @Test
    public void getRandomNumberBetweenTest() {
        int a = 1;
        int b = 10;
        int generated;
        for (int i=0; i<100;i++) {
            generated = Utils.getRandomNumberBetween(a,b);
            Assertions.assertTrue(generated>=a && generated<=b);
        }
    }

    @Test
    public void twoSquared() {
        Assertions.assertTrue(Utils.isPowerOfTwo(64));
        Assertions.assertTrue(Utils.isPowerOfTwo(8));
        Assertions.assertTrue(Utils.isPowerOfTwo(2048));
        Assertions.assertFalse(Utils.isPowerOfTwo(5));
        Assertions.assertFalse(Utils.isPowerOfTwo(14));
        Assertions.assertFalse(Utils.isPowerOfTwo(10));
    }

    @Test
    public void logn() {
        Assertions.assertEquals(5, Utils.expectedNumberOfRounds(32));
        Assertions.assertEquals(4, Utils.expectedNumberOfRounds(16));
        Assertions.assertEquals(11, Utils.expectedNumberOfRounds(2048));
    }

}
