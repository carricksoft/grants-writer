/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DMYParseNumericTest {

    private DMY dmy;

    @BeforeEach
    void setUp() {
        dmy = new DMYImpl();
    }

    @Test
    void highDayTest() {
        String input = "31/01/1953";
        dmy.parse(input);
        assertEquals("31", dmy.getDay());
    }

    @Test
    void tooLowDayTest() {
        String input = "00/01/1953";
        dmy.parse(input);
        assertNull(dmy.getDay());
    }

    @Test
    void tooHighDayTest() {
        String input = "32/01/1953";
        dmy.parse(input);
        assertNull(dmy.getDay());
    }

    @Test
    void highMonthTest() {
        String input = "31/12/1953";
        dmy.parse(input);
        assertEquals("12", dmy.getMonth());
    }

    @Test
    void tooHighMonthTest() {
        String input = "32/13/1953";
        dmy.parse(input);
        assertNull(dmy.getMonth());
    }

    @Test
    void lowYearTest() {
        String input = "31/12/1500";
        dmy.parse(input);
        assertEquals("1500", dmy.getYear());
    }

    @Test
    void tooLowYearTest() {
        String input = "32/13/1499";
        dmy.parse(input);
        assertNull(dmy.getYear());
    }

    @Test
    void highYearTest() {
        String input = "31/12/2030";
        dmy.parse(input);
        assertEquals("2030", dmy.getYear());
    }

    @Test
    void tooHighYearTest() {
        String input = "32/13/2031";
        dmy.parse(input);
        assertNull(dmy.getYear());
    }



}