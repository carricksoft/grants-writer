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

import static org.mockito.Mockito.inOrder;


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


}