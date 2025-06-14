/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

class TimelineDataGetterAndSetterTest {

    private TimelineData timelineData;

    @BeforeEach
    void setUp() {
        timelineData = new TimelineDataImpl();
    }

    @Test
    void getRefsTest() {
        assertNotNull(timelineData.getRefs());
    }

    @Test
    void setRefsTest() {
        SortedSet<String> refs = new TreeSet<>();
        refs.add(GetRandomString());
        timelineData.setRefs(refs);
        assertEquals(refs, timelineData.getRefs());
    }

    @Test
    void getTimelineTest() {
        assertEquals(0, timelineData.getTimeline().size());
    }

    @Test
    void setTimelineTest() {
        TreeMap<String, List<String>> timeline   = new TreeMap<>();
        List<String> stringList = new LinkedList<>();
        stringList.add(GetRandomString());
        timeline.put(GetRandomString(), stringList);
        timelineData.setTimeline(timeline);
        assertEquals(timeline, timelineData.getTimeline());
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Test
    void clearTimeLineTest() {
        TreeMap<String, List<String>> timeline   = new TreeMap<>();
        List<String> stringList = new LinkedList<>();
        stringList.add(GetRandomString());
        timeline.put(GetRandomString(), stringList);
        timelineData.clear();
        assertEquals(0, timelineData.getTimeline().size());
    }

    @Test
    void clearRefsTest() {
        SortedSet<String> refs = new TreeSet<>();
        refs.add(GetRandomString());
        timelineData.setRefs(refs);
        timelineData.clear();
        assertEquals(0, timelineData.getRefs().size());
    }

}