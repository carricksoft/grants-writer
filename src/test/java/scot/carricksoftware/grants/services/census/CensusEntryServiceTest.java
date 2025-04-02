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
import scot.carricksoftware.grants.converters.census.CensusEntryCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.CensusEntryConverterImpl;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.repositories.census.CensusEntryRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class CensusEntryServiceTest {

    CensusEntryService censusEntryService;

    @Mock
    CensusEntryRepository censusEntryRepositoryMock;

    @Mock
    CensusEntryConverterImpl censusEntryConverterImplMock;

    @Mock
    CensusEntryCommandConverterImpl censusEntryCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        censusEntryService = new CensusEntryServiceImpl(censusEntryRepositoryMock,
                censusEntryConverterImplMock,
                censusEntryCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @Mock
    Page<CensusEntry> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        censusEntryService.deleteById(id);
        verify(censusEntryRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(censusEntryRepositoryMock.count()).thenReturn(result);
        assertEquals(result, censusEntryService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<CensusEntry> result = new ArrayList<>();
        CensusEntry censusEntry = GetRandomCensusEntry();
        result.add(censusEntry);
        when(pageMock.getContent()).thenReturn(result);
        when(censusEntryRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, censusEntryService.getPagedCensusEntries(0));
    }


}