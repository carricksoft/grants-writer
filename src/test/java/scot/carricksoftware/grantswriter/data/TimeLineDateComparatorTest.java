/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class TimeLineDateComparatorTest {

    private TimeLineDateComparator comparator;

    private TreeMap<String, List<String>> map;

    @BeforeEach
    void setUp() {
        comparator = new TimeLineDateComparator();
        map = new TreeMap<>(comparator);
    }

    @Test
    void constructorTest() {
        assertNotNull(comparator);
    }

    @SuppressWarnings("unused")
    @Test
    void newDataIsSortedCorrectly() {
        List<String> StringList = new ArrayList<>(Arrays.asList("a","b","c"));
        map.put("25/01/54", StringList);
        map.put("25/01/52", StringList);
        map.put("25/01/53", StringList);

        List<String> data = new ArrayList<>();
        //noinspection UnusedAssignment
        data = map.get("25/01/54");
        int dbg = -1;
    }


}