/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DMYParseTest {

    private DMY dmy;

    @BeforeEach
    void setUp() {
        dmy = new DMYImpl();
    }

    @Test
    void normalTest() {
        String input = "01/02/1981";
        dmy = dmy.parse(input);

        assertEquals("01", dmy.getDay());
        assertEquals("02", dmy.getMonth());
        assertEquals("1981", dmy.getYear());
    }

    @Test
    void TrimmedTest() {
        String input = "0103/0204/198106";
        dmy = dmy.parse(input);

        assertEquals("01", dmy.getDay());
        assertEquals("02", dmy.getMonth());
        assertEquals("1981", dmy.getYear());
    }

    @Test
    void ShortTest() {
        String input = "1/2/3";
        dmy = dmy.parse(input);

        assertEquals("1 ", dmy.getDay());
        assertEquals("2 ", dmy.getMonth());
        assertEquals("3   ", dmy.getYear());
    }

}