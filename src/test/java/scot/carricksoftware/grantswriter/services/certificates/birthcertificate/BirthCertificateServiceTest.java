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
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.certificates.birthcertificate.BirthCertificateRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class BirthCertificateServiceTest {

    private BirthCertificateService birthCertificateService;

    private List<BirthCertificate> birthCertificateList;

    private Person person;

    @Mock
    BirthCertificateRepository birthCertificateRepositoryMock;

    @BeforeEach
    void setUp() {
        birthCertificateService = new BirthCertificateServiceImpl(birthCertificateRepositoryMock);
        birthCertificateList = new ArrayList<>();
        BirthCertificate birthCertificate = new BirthCertificate();
        birthCertificateList.add(birthCertificate);
        person = GetRandomPerson();
    }

    @Test
    void findAllByNewBornTest() {
        when(birthCertificateRepositoryMock.findAllByNewBorn(person)).thenReturn(birthCertificateList);

        List<BirthCertificate> result = birthCertificateService.findAllByNewBorn(person);
        assertEquals(birthCertificateList, result);
    }

    @Test
    void findAllByFatherTest() {
        when(birthCertificateRepositoryMock.findAllByFather(person)).thenReturn(birthCertificateList);

        List<BirthCertificate> result = birthCertificateService.findAllByFather(person);
        assertEquals(birthCertificateList, result);
    }

    @Test
    void findAllByMotherTest() {
        when(birthCertificateRepositoryMock.findAllByMother(person)).thenReturn(birthCertificateList);

        List<BirthCertificate> result = birthCertificateService.findAllByMother(person);
        assertEquals(birthCertificateList, result);
    }
}