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
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.certificates.deathcertificate.DeathCertificateRepository;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class DeathCertificateServiceTest {

    private DeathCertificateService deathCertificateService;
    private List<DeathCertificate> deathCertificateList;

    private Person person;

    @Mock
    DeathCertificateRepository deathCertificateRepositoryMock;

    @BeforeEach
    void setUp() {
        deathCertificateService = new DeathCertificateServiceImpl(deathCertificateRepositoryMock);
        deathCertificateList = new ArrayList<>();
        DeathCertificate deathCertificate = new DeathCertificate();
        deathCertificateList.add(deathCertificate);
        person = GetRandomPerson();
    }

    @Test
    void findAllByInformantTest() {
        when(deathCertificateRepositoryMock.findAllByInformant(person)).thenReturn(deathCertificateList);

        List<DeathCertificate> result = deathCertificateService.findAllByInformant(person);
        assertEquals(deathCertificateList, result);
    }

    @Test
    void findAllByDeceasedTest() {
        when(deathCertificateRepositoryMock.findAllByDeceased(person)).thenReturn(deathCertificateList);

        List<DeathCertificate> result = deathCertificateService.findAllByDeceased(person);
        assertEquals(deathCertificateList, result);
    }

    @Test
    void findAllBySpouseTest() {
        when(deathCertificateRepositoryMock.findAllBySpouse(person)).thenReturn(deathCertificateList);

        List<DeathCertificate> result = deathCertificateService.findAllBySpouse(person);
        assertEquals(deathCertificateList, result);
    }
}