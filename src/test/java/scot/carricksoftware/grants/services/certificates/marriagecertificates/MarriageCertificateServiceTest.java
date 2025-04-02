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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.repositories.certificates.MarriageCertificateRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomMarriageCertificate;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class MarriageCertificateServiceTest {

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

    @Mock
    Page<MarriageCertificate> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        marriageCertificateService.deleteById(id);
        verify(marriageCertificateRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(marriageCertificateRepositoryMock.count()).thenReturn(result);
        assertEquals(result, marriageCertificateService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<MarriageCertificate> result = new ArrayList<>();
        MarriageCertificate marriageCertificate = GetRandomMarriageCertificate();
        result.add(marriageCertificate);
        when(pageMock.getContent()).thenReturn(result);
        when(marriageCertificateRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, marriageCertificateService.getPagedMarriageCertificates(0));
    }


}