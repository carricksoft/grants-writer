/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.TimeLineData;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class GatherBirthCertificateNewBornTimeLineDataImplTest {

    private GatherBirthCertificateNewBornTimeLineData gatherBirthCertificateNewBornTimeLineData;

    @Mock
    TimeLineData timeLineDataMock;

    @BeforeEach
    void setUp() {
        gatherBirthCertificateNewBornTimeLineData = new GatherBirthCertificateNewBornTimeLineDataImpl(timeLineDataMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(gatherBirthCertificateNewBornTimeLineData);
    }

}