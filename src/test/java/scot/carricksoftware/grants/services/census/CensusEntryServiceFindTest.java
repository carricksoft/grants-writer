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
import scot.carricksoftware.grants.converters.census.CensusEntryCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.CensusEntryConverterImpl;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.repositories.census.CensusEntryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
public class CensusEntryServiceFindTest {

    CensusEntryService censusEntryService;

    @Mock
    CensusEntryRepository censusEntryRepositoryMock;

    @Mock
    CensusEntryConverterImpl censusEntryConverterMock;

    @Mock
    CensusEntryCommandConverterImpl censusEntryCommandConverterMock;

    @BeforeEach
    public void setUp() {
        censusEntryService = new CensusEntryServiceImpl(censusEntryRepositoryMock,
                censusEntryConverterMock,
                censusEntryCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<CensusEntry> censusEntries = new ArrayList<>();
        censusEntries.add(GetRandomCensusEntry());
        when(censusEntryRepositoryMock.findAll()).thenReturn(censusEntries);
        assertEquals(censusEntries, censusEntryService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        CensusEntry censusEntry = GetRandomCensusEntry();
        Optional<CensusEntry> censusEntryOptional = Optional.of(censusEntry);
        when(censusEntryRepositoryMock.findById(id)).thenReturn(censusEntryOptional);
        assertEquals(censusEntry, censusEntryService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<CensusEntry> empty = Optional.empty();
        when(censusEntryRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(censusEntryService.findById(id));
    }

}