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
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTabLeEnd;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTableStart;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


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
    private TimeLineData timeLineDataMock;

    @BeforeEach
    void setUp() {
        writeTimeLine = new WriteTimeLineImpl(
                fileWriterMock,
                latexLongTableStartMock,
                latexLongTabLeEndMock,
                timeLineDataMock);
    }

    @Test
    void writeTest() {
        writeTimeLine.write();
        InOrder inOrder = inOrder(latexLongTableStartMock, latexLongTabLeEndMock);
        inOrder.verify(latexLongTableStartMock).write("l l");
        inOrder.verify(latexLongTabLeEndMock).write();
    }

    @Test
    void writeTheDataTest() {
        String event = GetRandomString();

        TreeMap<DMY, List<String>> map = new TreeMap<>();
        DMY dmy = new DMYImpl();
        dmy.parse("25/01/1953");
        List<String> stringList = new ArrayList<>();
        stringList.add(event);
        map.put(dmy, stringList);
        when(timeLineDataMock.getTimeLine()).thenReturn(map);
        writeTimeLine.write();

        verify(fileWriterMock).writeLine(dmy + "&" + event + "\\\\");
    }


}