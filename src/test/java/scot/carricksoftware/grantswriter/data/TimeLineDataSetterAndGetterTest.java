/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.helpers.AddCensusEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class TimeLineDataSetterAndGetterTest {

    private TimeLineData timeLineData;

    @Mock
    private DMY dmyMock;
    @Mock
    AddCensusEntry addCensusEntryMock;


    @BeforeEach
    void setUp() {
        timeLineData = new TimeLineDataImpl(addCensusEntryMock);
    }

    @Test
    void getRefsTest() {
        assertEquals(0, timeLineData.getRefs().size());
    }

    @Test
    void setRefsTest() {
        SortedSet<String> refs = new TreeSet<>();
        refs.add(GetRandomString());
        timeLineData.setRefs(refs);
        assertEquals(refs, timeLineData.getRefs());
    }

    @Test
    void getTimeLineTest() {
        assertEquals(0, timeLineData.getTimeLine().size());
    }

    @Test
    void setTimeLineTest() {
        TreeMap<DMY, List<String>> timeLine = new TreeMap<>();
        List<String> list = new ArrayList<>();
        list.add(GetRandomString());
        timeLine.put(dmyMock, list);
        timeLineData.setTimeline(timeLine);
        assertEquals(timeLine, timeLineData.getTimeLine());
    }

    @Test
    void ClearTest() {
        SortedSet<String> refs = new TreeSet<>();
        refs.add(GetRandomString());
        List<String> list = new ArrayList<>();
        list.add(GetRandomString());
        TreeMap<DMY, List<String>> timeLine = new TreeMap<>();
        timeLine.put(dmyMock, list);

        timeLineData.setRefs(refs);
        timeLineData.setTimeline(timeLine);
        timeLineData.clear();

        assertEquals(0, timeLineData.getRefs().size());
        assertEquals(0, timeLineData.getTimeLine().size());
    }

}