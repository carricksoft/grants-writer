/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.people;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CensusEntryServiceTest {
private CensusEntryService censusEntryService;

    @BeforeEach
    void setUp() {
        censusEntryService = new CensusEntryServiceImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(censusEntryService);
    }
}