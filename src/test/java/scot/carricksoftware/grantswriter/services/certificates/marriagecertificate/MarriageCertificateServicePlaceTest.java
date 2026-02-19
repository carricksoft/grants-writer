/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.marriagecertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.repositories.certificates.marriagecertificate.MarriageCertificateRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class MarriageCertificateServicePlaceTest {

    private MarriageCertificateService marriageCertificateService;
    private List<MarriageCertificate> marriageCertificateList;

    private Place place;

    @Mock
    MarriageCertificateRepository marriageCertificateRepositoryMock;

    @BeforeEach
    void setUp() {
        marriageCertificateService = new MarriageCertificateServiceImpl(marriageCertificateRepositoryMock);
        marriageCertificateList = new ArrayList<>();
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificateList.add(marriageCertificate);
        place = GetRandomPlace();
    }

    @Test
    void findAllByWhereMarriedTest() {
        when(marriageCertificateRepositoryMock.findAllByWhereMarried(place)).thenReturn(marriageCertificateList);
        assertEquals(marriageCertificateList, marriageCertificateService.findAllByWhereMarried(place));
    }

}