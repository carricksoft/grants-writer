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
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTabLeEnd;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTableStart;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

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
    void writeTest() {
        writeReferences.write();
        InOrder inOrder = inOrder(latexLongTableStartMock, latexLongTabLeEndMock);
        inOrder.verify(latexLongTableStartMock).write("l");
        inOrder.verify(latexLongTabLeEndMock).write();
    }

    @Test
    void writeTheDataTest() {
        String event = GetRandomString();

        SortedSet<String> references = new TreeSet<>();
        references.add(event);

        when(timeLineDataMock.getRefs()).thenReturn(references);
        writeReferences.write();

        verify(fileWriterMock).writeLine(event + "\\\\");
    }


}