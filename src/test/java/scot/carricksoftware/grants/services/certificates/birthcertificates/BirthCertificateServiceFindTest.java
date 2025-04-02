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
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.repositories.certificates.BirthCertificateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomBirthCertificate;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
public class BirthCertificateServiceFindTest {

    BirthCertificateService birthCertificateService;

    @Mock
    BirthCertificateRepository birthCertificateRepositoryMock;

    @Mock
    BirthCertificateConverterImpl birthCertificateConverterMock;

    @Mock
    BirthCertificateCommandConverterImpl birthCertificateCommandConverterMock;

    @BeforeEach
    public void setUp() {
        birthCertificateService = new BirthCertificateServiceImpl(birthCertificateRepositoryMock,
                birthCertificateConverterMock,
                birthCertificateCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<BirthCertificate> countries = new ArrayList<>();
        countries.add(GetRandomBirthCertificate());
        when(birthCertificateRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, birthCertificateService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        BirthCertificate birthCertificate = GetRandomBirthCertificate();
        Optional<BirthCertificate> birthCertificateOptional = Optional.of(birthCertificate);
        when(birthCertificateRepositoryMock.findById(id)).thenReturn(birthCertificateOptional);
        assertEquals(birthCertificate, birthCertificateService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<BirthCertificate> empty = Optional.empty();
        when(birthCertificateRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(birthCertificateService.findById(id));
    }

}