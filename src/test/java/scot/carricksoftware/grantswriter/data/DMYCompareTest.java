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
        dmy.parse(sunday);
    }

    @Test
    void equalityTest() {
        DMY dmySunday2 = new DMYImpl();
        String sunday2 = "25/01/1953";
        dmySunday2.parse(sunday2);

        assertEquals(0, dmy.compareTo(dmySunday2));
    }

    @Test
    void nextDayTest() {
        String monday = "26/01/1953";
        DMY dmyMonday = new DMYImpl();
        dmyMonday.parse(monday);

        assertEquals(-1, dmy.compareTo(dmyMonday));
    }

    @Test
    void previousDayTest() {
        String saturday = "24/01/1953";

        DMY dmySaturday = new DMYImpl();
        dmySaturday.parse(saturday);
        assertEquals(1, dmy.compareTo(dmySaturday));
    }



}