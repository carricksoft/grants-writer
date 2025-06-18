/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTabLeEnd;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTableStart;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class WriteReferencesTest {

    private WriteReferences writeReferences;


    @Mock
    private FileWriter fileWriterMock;

    @Mock
    private LatexLongTableStart latexLongTableStartMock;

    @Mock
    private LatexLongTabLeEnd latexLongTabLeEndMock;

    @Mock
    TimeLineData timeLineDataMock;

    @BeforeEach
    void setUp() {
        writeReferences = new WriteReferencesImpl(
                fileWriterMock,
                latexLongTableStartMock,
                latexLongTabLeEndMock,
                timeLineDataMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(writeReferences);
    }

}