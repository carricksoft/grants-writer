/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.censusentry;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.repositories.censusentry.CensusEntryRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class CensusEntryServiceTest {
    private CensusEntryService censusEntryService;

    @Mock
    private CensusEntryRepository censusEntryRepositoryMock;


    @BeforeEach
    void setUp() {
        censusEntryService = new CensusEntryServiceImpl(censusEntryRepositoryMock);
    }

    @Test
    void findAllByPersonTest() {
        List<CensusEntry> censusEntryList = new ArrayList<>();
        CensusEntry censusEntry = new CensusEntry();
        censusEntryList.add(censusEntry);

        when(censusEntryRepositoryMock.findAllByPerson(any())).thenReturn(censusEntryList);
        assertEquals(censusEntryList, censusEntryService.findAllByPerson(GetRandomPerson()));
    }


}