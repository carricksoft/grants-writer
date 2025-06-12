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
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTabLeEnd;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTableStart;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WriteTimeLineTest {

    private WriteTimeLine writeTimeLine;

    @Mock
    private FileWriter fileWriterMock;

    @Mock
    private LatexLongTableStart latexLongTableStartMock;

    @Mock
    private LatexLongTabLeEnd latexLongTabLeEndMock;

    @Mock
    private DateSortLinkedMultiValueMap dateSortLinkedMultiValueMapMock;

    @BeforeEach
    void setUp() {
        writeTimeLine = new WriteTimeLineImpl(fileWriterMock, latexLongTableStartMock, latexLongTabLeEndMock, dateSortLinkedMultiValueMapMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(writeTimeLine);
    }
}