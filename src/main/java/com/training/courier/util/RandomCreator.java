package com.training.courier.util;

import java.util.Random;

public class RandomCreator {

    private static final Random random = new Random();

    public static int generateInt(int bound) {

        return random.nextInt(bound);
    }
}
