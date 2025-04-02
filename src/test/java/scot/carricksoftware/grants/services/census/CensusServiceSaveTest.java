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
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.converters.census.CensusCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.CensusConverterImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.repositories.census.CensusRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusCommand;


@ExtendWith(MockitoExtension.class)
public class CensusServiceSaveTest {

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


    @Test
    public void saveTest() {
        Census census = GetRandomCensus();
        when(censusRepositoryMock.save(census)).thenReturn(census);

        assertEquals(census, censusService.save(census));
    }

    @Test
    public void saveCensusCommandTest() {
        Census census = GetRandomCensus();
        CensusCommand censusCommand = GetRandomCensusCommand();
        when(censusCommandConverterImplMock.convert(censusCommand)).thenReturn(census);
        when(censusRepositoryMock.save(census)).thenReturn(census);
        when(censusConverterImplMock.convert((census))).thenReturn(censusCommand);

        assertEquals(censusCommand, censusService.saveCensusCommand(censusCommand));
    }


}