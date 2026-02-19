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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DivorceCertificateServiceTest {

    private DivorceCertificateService divorceCertificateService;

    @Mock
    DivorceCertificateRepository divorceCertificateRepositoryMock;

    private List<DivorceCertificate> certificates;

    @BeforeEach
    public void setUp() {
        divorceCertificateService = new DivorceCertificateServiceImpl(divorceCertificateRepositoryMock);
        certificates = new ArrayList<>();
        certificates.add(new DivorceCertificate());
    }

    @Test
    public void findAllByFirstPartyTest() {
        when(divorceCertificateRepositoryMock.findAllByFirstParty(any(Person.class))).thenReturn(certificates);
        assertEquals(certificates, divorceCertificateService.findAllByFirstParty(new Person()));
    }

    @Test
    public void findAllBySecondPartyTest() {
        when(divorceCertificateRepositoryMock.findAllBySecondParty(any(Person.class))).thenReturn(certificates);
        assertEquals(certificates, divorceCertificateService.findAllBySecondParty(new Person()));
    }

}