/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.birthcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.repositories.certificates.birthcertificate.BirthCertificateRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class BirthCertificateServicePlaceTest {

    private BirthCertificateService birthCertificateService;

    private List<BirthCertificate> birthCertificateList;

    private Place place;

    @Mock
    BirthCertificateRepository birthCertificateRepositoryMock;

    @BeforeEach
    void setUp() {
        birthCertificateService = new BirthCertificateServiceImpl(birthCertificateRepositoryMock);
        birthCertificateList = new ArrayList<>();
        BirthCertificate birthCertificate = new BirthCertificate();
        birthCertificateList.add(birthCertificate);
        place = GetRandomPlace();
    }

    @Test
    void findAllByWhereBornTest() {
        when(birthCertificateRepositoryMock.findAllByWhereBorn(place)).thenReturn(birthCertificateList);
        assertEquals(birthCertificateList, birthCertificateService.findAllByWhereBorn(place));
    }

}