/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.DMYImpl;

import java.util.Random;


@SuppressWarnings("unused")
@Component
public class GenerateRandomDMYValues {

    public static DMY GetRandomDMY() {
        DMY result = new DMYImpl();

        Random random = new Random();
        String day = last(2, getRandom(random, 1, 28));
        String month = last(2, getRandom(random, 1, 12));
        String year = last(4, getRandom(random, 1700, 1980));

        result.parse(day + "/" + month + "/" + year);
        return result;
    }

    public static int getRandom(Random random, int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public static String last(int size, int num) {
        String s = "0000" + num;
        int beginIndex = s.length() - size;
        return s.substring(beginIndex);
    }

}
