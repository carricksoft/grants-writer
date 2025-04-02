/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.certificates.birthcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.repositories.certificates.BirthCertificateRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomBirthCertificate;


@ExtendWith(MockitoExtension.class)
public class BirthCertificateServiceSaveTest {

    BirthCertificateService birthCertificateService;

    @Mock
    BirthCertificateRepository birthCertificateRepositoryMock;

    @Mock
    BirthCertificateConverterImpl birthCertificateConverterImplMock;

    @Mock
    BirthCertificateCommandConverterImpl birthCertificateCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        birthCertificateService = new BirthCertificateServiceImpl(birthCertificateRepositoryMock,
                birthCertificateConverterImplMock,
                birthCertificateCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @Test
    public void saveTest() {
        BirthCertificate birthCertificate = new BirthCertificate();

        when(birthCertificateRepositoryMock.save(birthCertificate)).thenReturn(birthCertificate);

        assertEquals(birthCertificate, birthCertificateService.save(birthCertificate));
    }

    @Test
    public void saveBirthCertificateCommandTest() {
        BirthCertificate birthCertificate = GetRandomBirthCertificate();
        BirthCertificateCommand birthCertificateCommand = new BirthCertificateCommandImpl();
        when(birthCertificateCommandConverterImplMock.convert(birthCertificateCommand)).thenReturn(birthCertificate);
        when(birthCertificateRepositoryMock.save(birthCertificate)).thenReturn(birthCertificate);
        when(birthCertificateConverterImplMock.convert((birthCertificate))).thenReturn(birthCertificateCommand);

        assertEquals(birthCertificateCommand, birthCertificateService.saveBirthCertificateCommand(birthCertificateCommand));
    }


}