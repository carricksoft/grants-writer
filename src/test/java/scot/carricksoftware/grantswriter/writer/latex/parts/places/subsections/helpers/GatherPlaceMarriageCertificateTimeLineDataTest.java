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
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.services.certificates.marriagecertificate.MarriageCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.marriagecertificate.GatherPlaceMarriageCertificateWhereMarriedTimeLineData;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class GatherPlaceMarriageCertificateTimeLineDataTest {

    private GatherPlaceMarriageCertificateTimeLineData gatherPlaceMarriageCertificateTimeLineData;

    @Mock
    private MarriageCertificateService marriageCertificateServiceMock;
    @Mock
    private GatherPlaceMarriageCertificateWhereMarriedTimeLineData
            gatherPlaceMarriageCertificateWhereMarriedTimeLineDataMock;

    List<MarriageCertificate> marriageCertificates;
    Place place;

    @BeforeEach
    void setUp() {
        gatherPlaceMarriageCertificateTimeLineData = new GatherPlaceMarriageCertificateTimeLineDataImpl(
                marriageCertificateServiceMock,
                gatherPlaceMarriageCertificateWhereMarriedTimeLineDataMock);
        marriageCertificates = new ArrayList<>();

        place = GetRandomPlace();
    }

    @Test
    void emptyTest() {
        when(marriageCertificateServiceMock.findAllByWhereMarried(place)).thenReturn(marriageCertificates);
        gatherPlaceMarriageCertificateTimeLineData.gather(place);
        verifyNoInteractions(gatherPlaceMarriageCertificateWhereMarriedTimeLineDataMock);
    }

    @Test
    void nonEmptyTest() {
        marriageCertificates.add(new MarriageCertificate());
        when(marriageCertificateServiceMock.findAllByWhereMarried(place)).thenReturn(marriageCertificates);
        gatherPlaceMarriageCertificateTimeLineData.gather(place);
        verify(gatherPlaceMarriageCertificateWhereMarriedTimeLineDataMock).gather(marriageCertificates);
    }

}