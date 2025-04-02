/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.census;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.census.CensusCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.CensusConverterImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.repositories.census.CensusRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class CensusServiceTest {

    CensusService censusService;

    @Mock
    CensusRepository censusRepositoryMock;

    @Mock
    CensusConverterImpl censusConverterImplMock;

    @Mock
    CensusCommandConverterImpl censusCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        censusService = new CensusServiceImpl(censusRepositoryMock,
                censusConverterImplMock,
                censusCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @Mock
    Page<Census> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        censusService.deleteById(id);
        verify(censusRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(censusRepositoryMock.count()).thenReturn(result);
        assertEquals(result, censusService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<Census> result = new ArrayList<>();
        Census census = GetRandomCensus();
        result.add(census);
        when(pageMock.getContent()).thenReturn(result);
        when(censusRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, censusService.getPagedCensuses(0));
    }


}