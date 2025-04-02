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
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.repositories.certificates.MarriageCertificateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomMarriageCertificate;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
public class MarriageCertificateServiceFindTest {

    MarriageCertificateService marriageCertificateService;

    @Mock
    MarriageCertificateRepository marriageCertificateRepositoryMock;

    @Mock
    MarriageCertificateConverterImpl marriageCertificateConverterMock;

    @Mock
    MarriageCertificateCommandConverterImpl marriageCertificateCommandConverterMock;

    @BeforeEach
    public void setUp() {
        marriageCertificateService = new MarriageCertificateServiceImpl(marriageCertificateRepositoryMock,
                marriageCertificateConverterMock,
                marriageCertificateCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<MarriageCertificate> countries = new ArrayList<>();
        countries.add(GetRandomMarriageCertificate());
        when(marriageCertificateRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, marriageCertificateService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        MarriageCertificate marriageCertificate = GetRandomMarriageCertificate();
        Optional<MarriageCertificate> marriageCertificateOptional = Optional.of(marriageCertificate);
        when(marriageCertificateRepositoryMock.findById(id)).thenReturn(marriageCertificateOptional);
        assertEquals(marriageCertificate, marriageCertificateService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<MarriageCertificate> empty = Optional.empty();
        when(marriageCertificateRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(marriageCertificateService.findById(id));
    }

}