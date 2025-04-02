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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.repositories.certificates.BirthCertificateRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomBirthCertificate;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class BirthCertificateServiceTest {

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

    @Mock
    Page<BirthCertificate> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        birthCertificateService.deleteById(id);
        verify(birthCertificateRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(birthCertificateRepositoryMock.count()).thenReturn(result);
        assertEquals(result, birthCertificateService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<BirthCertificate> result = new ArrayList<>();
        BirthCertificate birthCertificate = GetRandomBirthCertificate();
        result.add(birthCertificate);
        when(pageMock.getContent()).thenReturn(result);
        when(birthCertificateRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, birthCertificateService.getPagedBirthCertificates(0));
    }


}