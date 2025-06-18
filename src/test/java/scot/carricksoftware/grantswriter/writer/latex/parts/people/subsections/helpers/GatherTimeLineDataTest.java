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

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class GatherTimeLineDataTest {

    private GatherTimeLineData gatherTimeLineData;


    @Mock
    private GatherCensusTimeLineData gatherCensusTimeLineDataMock;

    @BeforeEach
    void setUp() {
        gatherTimeLineData = new GatherTimeLineDataImpl(gatherCensusTimeLineDataMock);
    }

    @Test
    void constructorTest(){
       assertNotNull(gatherTimeLineData);
    }


}