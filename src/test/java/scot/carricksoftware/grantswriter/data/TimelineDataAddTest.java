/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import scot.carricksoftware.grantswriter.domains.census.Census;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;

class TimelineDataAddTest {

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private TimelineData timelineData;

    @BeforeEach
    void setUp() {
        timelineData = new TimelineDataImpl();
    }

   @SuppressWarnings("unused")
   @Test
    void addTest() {
       CensusEntry censusEntry = new CensusEntry();
       Census census = new Census();
   }

}