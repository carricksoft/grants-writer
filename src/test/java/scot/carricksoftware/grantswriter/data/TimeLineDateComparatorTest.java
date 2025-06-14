/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TimeLineDateComparatorTest {

    private TimeLineDateComparator comparator;

    @BeforeEach
    void setUp() {
        comparator = new TimeLineDateComparator();
    }

    @Test
    void constructorTest() {
        assertNotNull(comparator);
    }
}