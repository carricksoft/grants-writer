/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.places.Place;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GatherPlaceTimeLineDataTest {

    private GatherPlaceTimeLineData gatherPlaceTimeLineData;

    @Mock
    private GatherPlaceCensusTimeLineData gatherPlaceCensusTimeLineDataMock;
    @Mock
    private GatherPlaceBirthCertificateTimeLineData gatherPlaceBirthCertificateTimeLineDataMock;
    @Mock
    private GatherPlaceDeathCertificateTimeLineData gatherPlaceDeathCertificateTimeLineDataMock;
    @Mock
    private GatherPlaceMarriageCertificateTimeLineData gatherPlaceMarriageCertificateTimeLineDataMock;
    @Mock
    private Place placeMock;

    @BeforeEach
    void setUp() {
        gatherPlaceTimeLineData = new GatherPlaceTimeLineDataImpl(gatherPlaceCensusTimeLineDataMock,
                gatherPlaceBirthCertificateTimeLineDataMock,
                gatherPlaceDeathCertificateTimeLineDataMock,
                gatherPlaceMarriageCertificateTimeLineDataMock);
    }

    @Test
    void gatherCensusEntryDataTest() {
        gatherPlaceTimeLineData.gather(placeMock);
        verify(gatherPlaceCensusTimeLineDataMock).gather(placeMock);
    }

    @Test
    void gatherBirthCertificateDataTest() {
        gatherPlaceTimeLineData.gather(placeMock);
        verify(gatherPlaceBirthCertificateTimeLineDataMock).gather(placeMock);
    }

    @Test
    void gatherDeathCertificateDataTest() {
        gatherPlaceTimeLineData.gather(placeMock);
        verify(gatherPlaceDeathCertificateTimeLineDataMock).gather(placeMock);
    }

    @Test
    void gatherMarriageCertificateDataTest() {
        gatherPlaceTimeLineData.gather(placeMock);
        verify(gatherPlaceMarriageCertificateTimeLineDataMock).gather(placeMock);
    }



}