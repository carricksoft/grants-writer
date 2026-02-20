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
import scot.carricksoftware.grantswriter.domains.certificates.deathcertificate.DeathCertificate;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.services.certificates.deathcertificate.DeathCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.deathcertificate.GatherPlaceDeathCertificateWhereDiedTimeLineData;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class GatherPlaceDeathCertificateTimeLineDataTest {

    private GatherPlaceDeathCertificateTimeLineData gatherPlaceDeathCertificateTimeLineData;

    @Mock
    private DeathCertificateService deathCertificateServiceMock;
    @Mock
    private GatherPlaceDeathCertificateWhereDiedTimeLineData gatherPlaceDeathCertificateNewBornTimeLineDataMock;

    List<DeathCertificate> deathCertificates;
    Place place;

    @BeforeEach
    void setUp() {
        gatherPlaceDeathCertificateTimeLineData = new GatherPlaceDeathCertificateTimeLineDataImpl(
                deathCertificateServiceMock,
                gatherPlaceDeathCertificateNewBornTimeLineDataMock);
        deathCertificates = new ArrayList<>();

        place = GetRandomPlace();
    }

    @Test
    void emptyTest() {
        List<DeathCertificate> deathCertificates = new ArrayList<>();
        when(deathCertificateServiceMock.findAllByWhereDied(place)).thenReturn(deathCertificates);
        gatherPlaceDeathCertificateTimeLineData.gather(place);
        verifyNoInteractions(gatherPlaceDeathCertificateNewBornTimeLineDataMock);
    }

    @Test
    void nonEmptyTest() {
        List<DeathCertificate> deathCertificates = new ArrayList<>();
        deathCertificates.add(new DeathCertificate());
        when(deathCertificateServiceMock.findAllByWhereDied(place)).thenReturn(deathCertificates);
        gatherPlaceDeathCertificateTimeLineData.gather(place);
        verify(gatherPlaceDeathCertificateNewBornTimeLineDataMock).gather(deathCertificates);
    }

}