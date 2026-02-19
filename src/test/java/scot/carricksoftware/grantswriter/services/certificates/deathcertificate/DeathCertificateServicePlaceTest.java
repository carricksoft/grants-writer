/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.deathcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.certificates.deathcertificate.DeathCertificate;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.repositories.certificates.deathcertificate.DeathCertificateRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class DeathCertificateServicePlaceTest {

    private DeathCertificateService deathCertificateService;
    private List<DeathCertificate> deathCertificateList;
    private Place place;

    @Mock
    DeathCertificateRepository deathCertificateRepositoryMock;

    @BeforeEach
    void setUp() {
        deathCertificateService = new DeathCertificateServiceImpl(deathCertificateRepositoryMock);
        deathCertificateList = new ArrayList<>();
        DeathCertificate deathCertificate = new DeathCertificate();
        deathCertificateList.add(deathCertificate);
        place = GetRandomPlace();
    }

    @Test
    void findAllByWhereDiedTest() {
        when(deathCertificateRepositoryMock.findAllByWhereDied(place)).thenReturn(deathCertificateList);
        assertEquals(deathCertificateList, deathCertificateService.findAllByWhereDied(place));
    }

}