/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimelineDataTest {

    private TimelineData timelineData;

    @BeforeEach
    void setUp() {
        timelineData = new TimelineDataImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(timelineData);
    }


}