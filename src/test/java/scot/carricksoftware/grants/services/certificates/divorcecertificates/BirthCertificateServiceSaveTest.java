/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.certificates.divorcecertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommandImpl;
import scot.carricksoftware.grants.converters.certificates.divorcecertificates.DivorceCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.divorcecertificates.DivorceCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.repositories.certificates.DivorceCertificateRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomDivorceCertificate;


@ExtendWith(MockitoExtension.class)
public class BirthCertificateServiceSaveTest {

    DivorceCertificateService divorceCertificateService;

    @Mock
    DivorceCertificateRepository divorceCertificateRepositoryMock;

    @Mock
    DivorceCertificateConverterImpl divorceCertificateConverterImplMock;

    @Mock
    DivorceCertificateCommandConverterImpl divorceCertificateCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        divorceCertificateService = new DivorceCertificateServiceImpl(divorceCertificateRepositoryMock,
                divorceCertificateConverterImplMock,
                divorceCertificateCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @Test
    public void saveTest() {
        DivorceCertificate divorceCertificate = new DivorceCertificate();

        when(divorceCertificateRepositoryMock.save(divorceCertificate)).thenReturn(divorceCertificate);

        assertEquals(divorceCertificate, divorceCertificateService.save(divorceCertificate));
    }

    @Test
    public void saveDivorceCertificateCommandTest() {
        DivorceCertificate divorceCertificate = GetRandomDivorceCertificate();
        DivorceCertificateCommand divorceCertificateCommand = new DivorceCertificateCommandImpl();
        when(divorceCertificateCommandConverterImplMock.convert(divorceCertificateCommand)).thenReturn(divorceCertificate);
        when(divorceCertificateRepositoryMock.save(divorceCertificate)).thenReturn(divorceCertificate);
        when(divorceCertificateConverterImplMock.convert((divorceCertificate))).thenReturn(divorceCertificateCommand);

        assertEquals(divorceCertificateCommand, divorceCertificateService.saveDivorceCertificateCommand(divorceCertificateCommand));
    }


}