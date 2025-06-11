/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.TimelineData;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.censusentry.CensusEntryService;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonSubSectionTimeLineWriterTest {

    private PersonSubSectionTimeLineWriter writer;

    @Mock
    private LatexSubSectionHeader latexSubSectionHeaderMock;

    @Mock
    private CensusEntryService censusEntryServiceMock;

    @Mock
    private TimelineData timelineDataMock;


    @Mock
    private Person personMock;

    @BeforeEach
    void setUp() {
        writer = new PersonSubSectionTimeLineWriterImpl(latexSubSectionHeaderMock, censusEntryServiceMock, timelineDataMock);
    }

    @Test
    void writeTest() {
        List<CensusEntry> censusEntryList = new ArrayList<>();
        censusEntryList.add(new CensusEntry());
        when(censusEntryServiceMock.findAllByPerson(any())).thenReturn(censusEntryList);
        writer.write(personMock);

        verify(latexSubSectionHeaderMock).write("Timeline");
        verify(timelineDataMock).add(censusEntryList);
    }
}