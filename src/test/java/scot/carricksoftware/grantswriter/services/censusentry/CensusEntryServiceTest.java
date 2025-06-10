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
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.censusentry.CensusEntryRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomCensusValues.GetRandomCensusEntry;

@ExtendWith(MockitoExtension.class)
class CensusEntryServiceTest {
    private CensusEntryService censusEntryService;

    @Mock
    private CensusEntryRepository censusEntryRepositoryMock;

    @Mock
    private Person personMock;

    @BeforeEach
    void setUp() {
        censusEntryService = new CensusEntryServiceImpl(censusEntryRepositoryMock);
    }

    @Test
    public void findAllByPersonTest() {
        List<CensusEntry> censusEntries = new ArrayList<>();
        censusEntries.add(GetRandomCensusEntry());
        when(censusEntryRepositoryMock.findAllByPerson(personMock)).thenReturn(censusEntries);
        assertEquals(censusEntries, censusEntryService.findAllByPerson(personMock));
    }


}