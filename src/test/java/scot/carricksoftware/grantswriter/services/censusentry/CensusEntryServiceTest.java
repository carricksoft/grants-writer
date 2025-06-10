/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.censusentry;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import scot.carricksoftware.grantswriter.repositories.censusentry.CensusEntryRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CensusEntryServiceTest {
    private CensusEntryService censusEntryService;

    @Mock
    private CensusEntryRepository censusEntryRepositoryMock;

    @BeforeEach
    void setUp() {
        censusEntryService = new CensusEntryServiceImpl(censusEntryRepositoryMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(censusEntryService);
    }
}