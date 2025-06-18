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
import scot.carricksoftware.grantswriter.domains.people.Person;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GatherTimeLineDataTest {

    private GatherTimeLineData gatherTimeLineData;

    @Mock
    private GatherCensusTimeLineData gatherCensusTimeLineDataMock;

    @Mock
    private Person personMock;

    @BeforeEach
    void setUp() {
        gatherTimeLineData = new GatherTimeLineDataImpl(gatherCensusTimeLineDataMock);
    }

    @Test
    void gatherTest(){
       gatherTimeLineData.gather(personMock);
       verify(gatherCensusTimeLineDataMock).gather(personMock);
    }

}