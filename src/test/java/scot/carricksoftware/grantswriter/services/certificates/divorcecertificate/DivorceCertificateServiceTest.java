/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:24. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.divorcecertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.certificates.divorcecertificate.DivorceCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.certificates.birthcertificate.DivorceCertificateRepository;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;


@ExtendWith(MockitoExtension.class)
public class DivorceCertificateServiceTest {

    private DivorceCertificateService divorceCertificateService;

    @Mock DivorceCertificateRepository divorceCertificateRepositoryMock;

    private Person person;

    @BeforeEach
    public void setUp() {
        divorceCertificateService = new DivorceCertificateServiceImpl(divorceCertificateRepositoryMock);
        person = GetRandomPerson();
    }

    @Test
    public void findAllByFirstPartyTest() {
        List<DivorceCertificate> certificates = new ArrayList<>();
        certificates.add(new DivorceCertificate());
        when(divorceCertificateRepositoryMock.findAllByFirstParty(person)).thenReturn(certificates);
        assertEquals(certificates, divorceCertificateService.findAllByFirstParty(person));
    }

    @Test
    public void findAllBySecondPartyTest() {
        List<DivorceCertificate> certificates = new ArrayList<>();
        certificates.add(new DivorceCertificate());
        when(divorceCertificateRepositoryMock.findAllBySecondParty(person)).thenReturn(certificates);
        assertEquals(certificates, divorceCertificateService.findAllBySecondParty(person));
    }

}