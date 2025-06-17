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
import scot.carricksoftware.grantswriter.data.DMYImpl;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTabLeEnd;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTableStart;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

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

    @Test
    void writeInnerTestNoValues() {
        TreeMap<DMY, List<String>> map = new TreeMap<>();
        writeTimeLine.write(map);
        verifyNoInteractions(fileWriterMock);
    }

    @Test
    void writeInnerTestValues() {
        TreeMap<DMY, List<String>> map = new TreeMap<>();
        DMY dmy = new DMYImpl();
        dmy.parse("25/01/1953");
        List<String> stringList = new ArrayList<>();
        String event = "Event";
        stringList.add(event);
        map.put(dmy, stringList);

        String required = "25/01/1953&" + event + "\\\\";

        writeTimeLine.write(map);
        verify(fileWriterMock).writeLine(required);
    }


}