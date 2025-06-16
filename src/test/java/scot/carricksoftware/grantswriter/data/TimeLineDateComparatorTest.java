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

    String nextYear;

    String nextMonth;

    String nextDay;

    String sameDay;


    @BeforeEach
    void setUp() {
        timeLineDateComparator = new TimeLineDateComparator();
        today = "25/01/1953";
        nextYear = "25/01/1954";
        nextMonth = "25/02/1953";
        nextDay = "26/01/1953";
        sameDay = "25/01/1953";

    }

    @Test
    void timeLineNextYearTest() {
        assertEquals(1, timeLineDateComparator.compare(nextYear, today));
        assertEquals(-1, timeLineDateComparator.compare(today, nextYear));
    }

    @Test
    void timeLineNextMonthTest() {
        assertEquals(1, timeLineDateComparator.compare(nextMonth, today));
        assertEquals(-1, timeLineDateComparator.compare(today, nextMonth));
    }

    @Test
    void timeLineNextDayTest() {
        assertEquals(1, timeLineDateComparator.compare(nextDay, today));
        assertEquals(-1, timeLineDateComparator.compare(today, nextDay));
    }

    @Test
    void timeLineSameDayTest() {
        assertEquals(-1, timeLineDateComparator.compare(sameDay, today));
    }

}