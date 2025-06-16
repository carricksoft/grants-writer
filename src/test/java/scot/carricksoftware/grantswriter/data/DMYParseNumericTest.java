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
    void tooLowDayTest() {
        String input = "00/01/1953";
        dmy.setDay("99");
        dmy.parse(input);
        assertNull(dmy.getDay());
    }

    @Test
    void lowDayTest() {
        String input = "01/01/1953";
        dmy.setDay("99");
        dmy.parse(input);
        assertEquals("01", dmy.getDay());
    }

    @Test
    void highDayTest() {
        String input = "31/01/1953";
        dmy.setDay("99");
        dmy.parse(input);
        assertEquals("31", dmy.getDay());
    }

    @Test
    void tooHighDayTest() {
        String input = "32/01/1953";
        dmy.setDay("99");
        dmy.parse(input);
        assertNull(dmy.getDay());
    }



}