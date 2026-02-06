/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexItemizeStart;
import scot.carricksoftware.grantswriter.writer.latex.LatexItemizeEnd;


import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


@ExtendWith(MockitoExtension.class)
class WriteReferencesTest {

    private WriteReferences writeReferences;

    @Mock
    private FileWriter fileWriterMock;
    @Mock
    private LatexItemizeStart latexItemizeStartMock;
    @Mock
    private LatexItemizeEnd latexItemizeEndMock;
    @Mock
    private TimeLineData timeLineDataMock;

    @BeforeEach
    void setUp() {
        writeReferences = new WriteReferencesImpl(
                fileWriterMock,
                timeLineDataMock,
                latexItemizeStartMock,
                latexItemizeEndMock);
    }

    @Test
    void writeNoReferencesTest() {
        SortedSet<String> references = new TreeSet<>();
        when (timeLineDataMock.getRefs()).thenReturn(references);
        writeReferences.write();
        verifyNoInteractions(latexItemizeStartMock);
        verifyNoInteractions(latexItemizeEndMock);
        verifyNoInteractions(fileWriterMock);
    }

    @Test
    void writeReferencesTest() {
        SortedSet<String> references = new TreeSet<>();
        String reference = GetRandomString();
        references.add(reference);
        when (timeLineDataMock.getRefs()).thenReturn(references);

        InOrder inOrder = inOrder(latexItemizeStartMock, fileWriterMock, latexItemizeEndMock);
        writeReferences.write();
        inOrder.verify(latexItemizeStartMock).write();
        inOrder.verify(fileWriterMock).writeLine("\\item " + reference);
        inOrder.verify(latexItemizeEndMock).write();
    }

    @Test
    void writeTheDataTest() {
        assertTrue(true);
    }


}