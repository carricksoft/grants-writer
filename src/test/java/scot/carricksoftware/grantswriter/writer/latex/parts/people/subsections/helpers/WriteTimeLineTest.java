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
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTabLeEnd;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTableStart;

import java.util.List;
import java.util.TreeMap;

import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
class WriteTimeLineTest {

    private WriteTimeLine writeTimeLine;

    @Mock
    private FileWriter fileWriterMock;

    @Mock
    LatexLongTableStart latexLongTableStartMock;

    @Mock
    LatexLongTabLeEnd latexLongTabLeEndMock;

    @BeforeEach
    void setUp() {
        writeTimeLine = new WriteTimeLineImpl(fileWriterMock, latexLongTableStartMock, latexLongTabLeEndMock);
    }

    @Test
    void writeOuterTest() {
        TreeMap<DMY, List<String>> map = new TreeMap<>();
        InOrder inOrder = inOrder(latexLongTableStartMock, latexLongTabLeEndMock);

        writeTimeLine.write(map);
        inOrder.verify(latexLongTableStartMock).write("l l");
        inOrder.verify(latexLongTabLeEndMock).write();
    }

}