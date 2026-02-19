/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.census.Census;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.repositories.census.CensusRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CensusServiceTest {

    private CensusService censusService;

    @Mock
    private CensusRepository censusRepositoryMock;

    @BeforeEach
    void setUp() {
        censusService = new CensusServiceImpl(censusRepositoryMock);
    }

    @Test
    void findAllByPlaceTest() {
        List<Census> censusList = new ArrayList<>();
        Census census = new Census();
        censusList.add(census);

        when(censusRepositoryMock.findAllByPlace(any())).thenReturn(censusList);
        assertEquals(censusList, censusService.findAllByPlace(new Place()));
    }
}