/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

        assertNull(dmy.getDay());
        assertNull(dmy.getMonth());
        assertNull(dmy.getYear());
    }

    @Test
    void invalidNumericDayTest() {
        String input = "33/1/1953";
        dmy = dmy.parse(input);

        assertNull(dmy.getDay());
    }

    @Test
    void invalidDayTest() {
        String input = "z/1/1953";
        dmy = dmy.parse(input);
        assertNull(dmy.getDay());
    }

    @Test
    void invalidNumericMonthTest() {
        String input = "25/13/1953";
        dmy = dmy.parse(input);
        assertNull(dmy.getMonth());
    }

    @Test
    void invalidMonthTest() {
        String input = "25/z/1953";
        dmy = dmy.parse(input);
        assertNull(dmy.getMonth());
    }

    @Test
    void invalidNumericHighYearTest() {
        String input = "25/01/2050";
        dmy = dmy.parse(input);
        assertNull(dmy.getYear());
    }

    @Test
    void invalidNumericLowYearTest() {
        String input = "25/01/25";
        dmy = dmy.parse(input);
        assertNull(dmy.getYear());
    }

    @Test
    void invalidYearTest() {
        String input = "25/01/z";
        dmy = dmy.parse(input);
        assertNull(dmy.getYear());
    }

}