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
import scot.carricksoftware.grants.converters.census.CensusCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.CensusConverterImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.repositories.census.CensusRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
public class CensusServiceFindTest {

    CensusService censusService;

    @Mock
    CensusRepository censusRepositoryMock;

    @Mock
    CensusConverterImpl censusConverterMock;

    @Mock
    CensusCommandConverterImpl censusCommandConverterMock;

    @BeforeEach
    public void setUp() {
        censusService = new CensusServiceImpl(censusRepositoryMock,
                censusConverterMock,
                censusCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<Census> censuses = new ArrayList<>();
        censuses.add(GetRandomCensus());
        when(censusRepositoryMock.findAll()).thenReturn(censuses);
        assertEquals(censuses, censusService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        Census census = GetRandomCensus();
        Optional<Census> censusOptional = Optional.of(census);
        when(censusRepositoryMock.findById(id)).thenReturn(censusOptional);
        assertEquals(census, censusService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<Census> empty = Optional.empty();
        when(censusRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(censusService.findById(id));
    }

}