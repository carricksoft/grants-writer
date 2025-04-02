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
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.converters.census.CensusEntryCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.CensusEntryConverterImpl;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.repositories.census.CensusEntryRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.*;


@ExtendWith(MockitoExtension.class)
public class CensusServiceEntrySaveTest {

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


    @Test
    public void saveTest() {
        CensusEntry censusEntry = GetRandomCensusEntry();
        when(censusEntryRepositoryMock.save(censusEntry)).thenReturn(censusEntry);

        assertEquals(censusEntry, censusEntryService.save(censusEntry));
    }

    @Test
    public void saveCensusEntryCommandTest() {
        CensusEntry censusEntry = GetRandomCensusEntry();
        CensusEntryCommand censusEntryCommand = GetRandomCensusEntryCommand();
        when(censusEntryCommandConverterImplMock.convert(censusEntryCommand)).thenReturn(censusEntry);
        when(censusEntryRepositoryMock.save(censusEntry)).thenReturn(censusEntry);
        when(censusEntryConverterImplMock.convert((censusEntry))).thenReturn(censusEntryCommand);

        assertEquals(censusEntryCommand, censusEntryService.saveCensusEntryCommand(censusEntryCommand));
    }


}