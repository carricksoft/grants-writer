/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.TimeLineData;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClearExistingTimeLineDataTest {

    private ClearExistingTimeLineData clearExistingTimeLineData;

    @Mock
    private TimeLineData timeLineDataMock;

    @BeforeEach
    void setUp() {
        clearExistingTimeLineData = new ClearExistingTimeLineDataImpl(timeLineDataMock);
    }

    @Test
    void clearTest() {
        clearExistingTimeLineData.clear();
        verify(timeLineDataMock).clear();
    }
}