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
import scot.carricksoftware.grantswriter.writer.latex.LatexItemiseStart;
import scot.carricksoftware.grantswriter.writer.latex.LatexItemizeEnd;


import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
class WriteReferencesTest {

    private WriteReferences writeReferences;

    @Mock
    private FileWriter fileWriterMock;
    @Mock
    private LatexItemiseStart latexItemiseStartMock;
    @Mock
    private LatexItemizeEnd latexItemizeEndMock;
    @Mock
    private TimeLineData timeLineDataMock;

    @BeforeEach
    void setUp() {
        writeReferences = new WriteReferencesImpl(
                fileWriterMock,
                timeLineDataMock,
                latexItemiseStartMock,
                latexItemizeEndMock);
    }

    @Test
    void writeTest() {
        assertTrue(true);
    }

    @Test
    void writeTheDataTest() {
        assertTrue(true);
    }


}