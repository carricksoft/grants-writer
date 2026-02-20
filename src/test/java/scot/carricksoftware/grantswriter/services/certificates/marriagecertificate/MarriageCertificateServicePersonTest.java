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
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.certificates.marriagecertificate.MarriageCertificateRepository;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class MarriageCertificateServicePersonTest {

    private MarriageCertificateService marriageCertificateService;
    private List<MarriageCertificate> marriageCertificateList;

    private Person person;

    @Mock
    MarriageCertificateRepository marriageCertificateRepositoryMock;

    @BeforeEach
    void setUp() {
        marriageCertificateService = new MarriageCertificateServiceImpl(marriageCertificateRepositoryMock);
        marriageCertificateList = new ArrayList<>();
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificateList.add(marriageCertificate);
        person = GetRandomPerson();
    }

    @Test
    void findAllByBrideTest() {
        when(marriageCertificateRepositoryMock.findAllByBride(person)).thenReturn(marriageCertificateList);

        List<MarriageCertificate> result = marriageCertificateService.findAllByBride(person);
        assertEquals(marriageCertificateList, result);
    }

    @Test
    void findAllByGroomTest() {
        when(marriageCertificateRepositoryMock.findAllByGroom(person)).thenReturn(marriageCertificateList);
        assertEquals(marriageCertificateList, marriageCertificateService.findAllByGroom(person));
    }

    @Test
    void findAllByFirstWitnessTest() {
        when(marriageCertificateRepositoryMock.findAllByFirstWitness(person)).thenReturn(marriageCertificateList);
        assertEquals(marriageCertificateList, marriageCertificateService.findAllByFirstWitness(person));
    }

    @Test
    void findAllBySecondWitnessTest() {
        when(marriageCertificateRepositoryMock.findAllBySecondWitness(person)).thenReturn(marriageCertificateList);
        assertEquals(marriageCertificateList, marriageCertificateService.findAllBySecondWitness(person));
    }
}