/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:25. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.certificates.deathcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.repositories.certificates.DeathCertificateRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomDeathCertificate;


@ExtendWith(MockitoExtension.class)
public class DeathCertificateServiceSaveTest {

    DeathCertificateService deathCertificateService;

    @Mock
    DeathCertificateRepository deathCertificateRepositoryMock;

    @Mock
    DeathCertificateConverterImpl deathCertificateConverterImplMock;

    @Mock
    DeathCertificateCommandConverterImpl deathCertificateCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        deathCertificateService = new DeathCertificateServiceImpl(deathCertificateRepositoryMock,
                deathCertificateConverterImplMock,
                deathCertificateCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @Test
    public void saveTest() {
        DeathCertificate deathCertificate = new DeathCertificate();

        when(deathCertificateRepositoryMock.save(deathCertificate)).thenReturn(deathCertificate);

        assertEquals(deathCertificate, deathCertificateService.save(deathCertificate));
    }

    @Test
    public void saveDeathCertificateCommandTest() {
        DeathCertificate deathCertificate = GetRandomDeathCertificate();
        DeathCertificateCommand deathCertificateCommand = new DeathCertificateCommandImpl();
        when(deathCertificateCommandConverterImplMock.convert(deathCertificateCommand)).thenReturn(deathCertificate);
        when(deathCertificateRepositoryMock.save(deathCertificate)).thenReturn(deathCertificate);
        when(deathCertificateConverterImplMock.convert((deathCertificate))).thenReturn(deathCertificateCommand);

        assertEquals(deathCertificateCommand, deathCertificateService.saveDeathCertificateCommand(deathCertificateCommand));
    }


}