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
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.censusentry.CensusEntryService;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.WriteTimeLine;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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
    private TimeLineData timeLineDataMock;

    @Mock
    private WriteTimeLine writeTimeLineMock;

    @Mock
    private Person personMock;

    @BeforeEach
    void setUp() {
        writer = new PersonSubSectionTimeLineWriterImpl(
                latexSubSectionHeaderMock,
                censusEntryServiceMock,
                timeLineDataMock,
                writeTimeLineMock);
    }

    @Test
    void writeHeaderTest() {
        writer.write(personMock);
        verify(latexSubSectionHeaderMock).write("Timeline");
    }

    @Test
    void clearTest() {
        writer.write(personMock);
        verify(timeLineDataMock).clear();
    }

    @Test
    void addTest() {
        List<CensusEntry> censusEntries = new ArrayList<>();
        when(censusEntryServiceMock.findAllByPerson(personMock)).thenReturn(censusEntries);
        writer.write(personMock);
        verify(timeLineDataMock).add(censusEntries);
    }

    @Test
    void writeTest() {
        TreeMap<DMY, List<String>> timeLine = new TreeMap<>();
        List<CensusEntry> censusEntries = new ArrayList<>();
        when(censusEntryServiceMock.findAllByPerson(personMock)).thenReturn(censusEntries);
        when(timeLineDataMock.getTimeLine()).thenReturn(timeLine);
        when(censusEntryServiceMock.findAllByPerson(personMock)).thenReturn(censusEntries);

        writer.write(personMock);
        verify(writeTimeLineMock).write(timeLine);
    }

}