/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.services.certificates.birthcertificate.BirthCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.birthcertificate.GatherPlaceBirthCertificateWhereBornTimeLineData;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class GatherPlaceBirthCertificateTimeLineDataTest {

    private GatherPlaceBirthCertificateTimeLineData gatherPlaceBirthCertificateTimeLineData;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;
    @Mock
    private GatherPlaceBirthCertificateWhereBornTimeLineData gatherPlaceBirthCertificateNewBornTimeLineDataMock;

    List<BirthCertificate> birthCertificates;
    Place place;

    @BeforeEach
    void setUp() {
        gatherPlaceBirthCertificateTimeLineData = new GatherPlaceBirthCertificateTimeLineDataImpl(
                birthCertificateServiceMock,
                gatherPlaceBirthCertificateNewBornTimeLineDataMock);
        birthCertificates = new ArrayList<>();

        place = GetRandomPlace();
    }

    @Test
    void emptyTest() {
        when(birthCertificateServiceMock.findAllByWhereBorn(place)).thenReturn(birthCertificates);
        gatherPlaceBirthCertificateTimeLineData.gather(place);
        verifyNoInteractions(gatherPlaceBirthCertificateNewBornTimeLineDataMock);
    }

    @Test
    void nonEmptyTest() {
        birthCertificates.add(new BirthCertificate());
        when(birthCertificateServiceMock.findAllByWhereBorn(place)).thenReturn(birthCertificates);
        gatherPlaceBirthCertificateTimeLineData.gather(place);
        verify(gatherPlaceBirthCertificateNewBornTimeLineDataMock).gather(birthCertificates);
    }

}