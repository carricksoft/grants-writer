/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;

import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
class AddCensusEntryTest {

    private AddCensusEntry entry;

    @SuppressWarnings("unused")
    @Mock
    private TreeMap<DMY, List<String>> timelineMock;

    @SuppressWarnings("unused")
    @Mock
    private List<CensusEntry> censusEntryListMock;


    @BeforeEach
    void setUp() {
        entry = new AddCensusEntryImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(entry);
    }
}