/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TimeLineDateComparatorTest {

    private TimeLineDateComparator timeLineDateComparator;

    String today;

    String yesterday;

    String today2;


    @BeforeEach
    void setUp() {
        timeLineDateComparator = new TimeLineDateComparator();
        today = "25/01/1953";
        today2 = "25/01/1953";
        yesterday = "24/01/1953";
    }

    @Test
    void timeLineAddCensusEntryTest() {
        assertEquals(1, timeLineDateComparator.compare(today, yesterday));
        assertEquals(-1, timeLineDateComparator.compare(yesterday, today));
        assertEquals(-1, timeLineDateComparator.compare(today, today2));
    }

}