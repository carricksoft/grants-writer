/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DMYParseNumericYearTest {

    private DMY dmy;

    @BeforeEach
    void setUp() {
        dmy = new DMYImpl();
    }

    @Test
    void tooLowYearTest() {
        String input = "25/01/1499";
        dmy.setYear("99");
        dmy.parse(input);
        assertNull(dmy.getYear());
    }

    @Test
    void lowYearTest() {
        String input = "25/01/1500";
        dmy.setYear("99");
        dmy.parse(input);
        assertEquals("1500", dmy.getYear());
    }

    @Test
    void highYearTest() {
        String input = "25/01/2030";
        dmy.setYear("99");
        dmy.parse(input);
        assertEquals("2030", dmy.getYear());
    }

    @Test
    void tooHighYearTest() {
        String input = "25/01/2031";
        dmy.setYear("99");
        dmy.parse(input);
        assertNull(dmy.getYear());
    }

    @Test
    void invalidYearTest() {
        String input = "25/01/zz";
        dmy.setYear("99");
        dmy.parse(input);
        assertNull(dmy.getYear());
    }



}