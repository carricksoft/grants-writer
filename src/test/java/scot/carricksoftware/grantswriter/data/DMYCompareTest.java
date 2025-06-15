/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DMYCompareTest {

    private DMY dmy;

    @BeforeEach
    void setUp() {
        dmy = new DMYImpl();
        String sunday = "25/01/1953";
        dmy = dmy.parse(sunday);
    }

    @Test
    void equalityTest() {
        String sunday2 = "25/01/1953";
        assertEquals(0, dmy.compareTo(dmy.parse(sunday2)));
    }

    @Test
    void nextDayTest() {
        String monday = "26/01/1953";
        assertEquals(-1, dmy.compareTo(dmy.parse(monday)));
    }

    @Test
    void previousDayTest() {
        String saturday = "24/01/1953";
        assertEquals(1, dmy.compareTo(dmy.parse(saturday)));
    }



}