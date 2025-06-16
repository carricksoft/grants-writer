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

import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class TimeLineDataTest {


    private TimeLineData timeLineData;

    @Mock
    private DMY dmyMock;

    @Mock
    private TimeLineDateComparator timeLineDateComparatorMock;


    @BeforeEach
    void setUp() {
        timeLineData = new TimeLineDataImpl(dmyMock, timeLineDateComparatorMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(timeLineData);
    }

    @Test
    void getRefSTest(){
        assertEquals(0, timeLineData.getRefs().size());
    }

    @Test
    void setRefsTest(){
        SortedSet<String> refs = new TreeSet<>();
        refs.add(GetRandomString());
        timeLineData.setRefs(refs);
        assertEquals(refs, timeLineData.getRefs());
    }

}