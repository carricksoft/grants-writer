/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.certificates.marriagecertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.repositories.certificates.MarriageCertificateRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomMarriageCertificate;


@ExtendWith(MockitoExtension.class)
public class MarriageCertificateServiceSaveTest {

    MarriageCertificateService marriageCertificateService;

    @Mock
    MarriageCertificateRepository marriageCertificateRepositoryMock;

    @Mock
    MarriageCertificateConverterImpl marriageCertificateConverterImplMock;

    @Mock
    MarriageCertificateCommandConverterImpl marriageCertificateCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        marriageCertificateService = new MarriageCertificateServiceImpl(marriageCertificateRepositoryMock,
                marriageCertificateConverterImplMock,
                marriageCertificateCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @Test
    public void saveTest() {
        MarriageCertificate marriageCertificate = new MarriageCertificate();

        when(marriageCertificateRepositoryMock.save(marriageCertificate)).thenReturn(marriageCertificate);

        assertEquals(marriageCertificate, marriageCertificateService.save(marriageCertificate));
    }

    @Test
    public void saveMarriageCertificateCommandTest() {
        MarriageCertificate marriageCertificate = GetRandomMarriageCertificate();
        MarriageCertificateCommand marriageCertificateCommand = new MarriageCertificateCommandImpl();
        when(marriageCertificateCommandConverterImplMock.convert(marriageCertificateCommand)).thenReturn(marriageCertificate);
        when(marriageCertificateRepositoryMock.save(marriageCertificate)).thenReturn(marriageCertificate);
        when(marriageCertificateConverterImplMock.convert((marriageCertificate))).thenReturn(marriageCertificateCommand);

        assertEquals(marriageCertificateCommand, marriageCertificateService.saveMarriageCertificateCommand(marriageCertificateCommand));
    }


}