/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:26. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.certificates.deathcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.repositories.certificates.DeathCertificateRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomDeathCertificate;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class DeathCertificateServiceTest {

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

    @Mock
    Page<DeathCertificate> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        deathCertificateService.deleteById(id);
        verify(deathCertificateRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(deathCertificateRepositoryMock.count()).thenReturn(result);
        assertEquals(result, deathCertificateService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<DeathCertificate> result = new ArrayList<>();
        DeathCertificate deathCertificate = GetRandomDeathCertificate();
        result.add(deathCertificate);
        when(pageMock.getContent()).thenReturn(result);
        when(deathCertificateRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, deathCertificateService.getPagedDeathCertificates(0));
    }


}