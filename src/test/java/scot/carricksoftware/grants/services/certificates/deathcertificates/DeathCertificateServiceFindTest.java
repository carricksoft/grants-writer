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
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.repositories.certificates.DeathCertificateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomDeathCertificate;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
public class DeathCertificateServiceFindTest {

    DeathCertificateService deathCertificateService;

    @Mock
    DeathCertificateRepository deathCertificateRepositoryMock;

    @Mock
    DeathCertificateConverterImpl deathCertificateConverterMock;

    @Mock
    DeathCertificateCommandConverterImpl deathCertificateCommandConverterMock;

    @BeforeEach
    public void setUp() {
        deathCertificateService = new DeathCertificateServiceImpl(deathCertificateRepositoryMock,
                deathCertificateConverterMock,
                deathCertificateCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<DeathCertificate> countries = new ArrayList<>();
        countries.add(GetRandomDeathCertificate());
        when(deathCertificateRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, deathCertificateService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        DeathCertificate deathCertificate = GetRandomDeathCertificate();
        Optional<DeathCertificate> deathCertificateOptional = Optional.of(deathCertificate);
        when(deathCertificateRepositoryMock.findById(id)).thenReturn(deathCertificateOptional);
        assertEquals(deathCertificate, deathCertificateService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<DeathCertificate> empty = Optional.empty();
        when(deathCertificateRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(deathCertificateService.findById(id));
    }

}