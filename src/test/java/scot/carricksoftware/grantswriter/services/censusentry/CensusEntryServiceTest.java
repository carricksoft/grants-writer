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
import scot.carricksoftware.grantswriter.repositories.censusentry.CensusEntryRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void constructorTest() {
        assertNotNull(censusEntryService);
    }


}