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
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.services.censusentry.CensusEntryService;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.WriteTimeLine;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @BeforeEach
    void setUp() {
        writer = new PersonSubSectionTimeLineWriterImpl(
                latexSubSectionHeaderMock,
                censusEntryServiceMock,
                timeLineDataMock,
                writeTimeLineMock);
    }


    @Test
    void writeTest() {
       assertNotNull(writer);
    }
}