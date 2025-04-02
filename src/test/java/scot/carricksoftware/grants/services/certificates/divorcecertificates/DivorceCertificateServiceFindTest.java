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
import scot.carricksoftware.grants.converters.certificates.divorcecertificates.DivorceCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.divorcecertificates.DivorceCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.repositories.certificates.DivorceCertificateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomDivorceCertificate;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
public class DivorceCertificateServiceFindTest {

    DivorceCertificateService divorceCertificateService;

    @Mock
    DivorceCertificateRepository divorceCertificateRepositoryMock;

    @Mock
    DivorceCertificateConverterImpl divorceCertificateConverterMock;

    @Mock
    DivorceCertificateCommandConverterImpl divorceCertificateCommandConverterMock;

    @BeforeEach
    public void setUp() {
        divorceCertificateService = new DivorceCertificateServiceImpl(divorceCertificateRepositoryMock,
                divorceCertificateConverterMock,
                divorceCertificateCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<DivorceCertificate> countries = new ArrayList<>();
        countries.add(GetRandomDivorceCertificate());
        when(divorceCertificateRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, divorceCertificateService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        DivorceCertificate divorceCertificate = GetRandomDivorceCertificate();
        Optional<DivorceCertificate> divorceCertificateOptional = Optional.of(divorceCertificate);
        when(divorceCertificateRepositoryMock.findById(id)).thenReturn(divorceCertificateOptional);
        assertEquals(divorceCertificate, divorceCertificateService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<DivorceCertificate> empty = Optional.empty();
        when(divorceCertificateRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(divorceCertificateService.findById(id));
    }

}