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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.certificates.divorcecertificates.DivorceCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.divorcecertificates.DivorceCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.repositories.certificates.DivorceCertificateRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomDivorceCertificate;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class DivorceCertificateServiceTest {

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

    @Mock
    Page<DivorceCertificate> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        divorceCertificateService.deleteById(id);
        verify(divorceCertificateRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(divorceCertificateRepositoryMock.count()).thenReturn(result);
        assertEquals(result, divorceCertificateService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<DivorceCertificate> result = new ArrayList<>();
        DivorceCertificate divorceCertificate = GetRandomDivorceCertificate();
        result.add(divorceCertificate);
        when(pageMock.getContent()).thenReturn(result);
        when(divorceCertificateRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, divorceCertificateService.getPagedDivorceCertificates(0));
    }


}