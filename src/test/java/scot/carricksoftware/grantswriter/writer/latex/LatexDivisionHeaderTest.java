/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.helpers.LatexDivision;
import scot.carricksoftware.grantswriter.writer.FileWriter;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class LatexDivisionHeaderTest {

    @SuppressWarnings({"unused"})
    private LatexDivisionHeader header;

    @Mock
    private FileWriter fileWriterMock;
    @Mock
    private LatexDivision latexDivisionMock;

    @BeforeEach
    void setUp() {
        header = new LatexDivisionHeaderImpl(fileWriterMock, latexDivisionMock);
    }

    @Test
    void writeTest() {
        Integer level = 1;
        String title = GetRandomString();
        String description = GetRandomString();
        when(latexDivisionMock.header(level)).thenReturn(description);

        header.write(level,title);

        verify(fileWriterMock).writeLine(description + "{" + title + "}");
    }

    @Test
    void writeStringTest() {
        Integer level = 1;
        String title = GetRandomString();
        String description = GetRandomString();
        when(latexDivisionMock.header(level)).thenReturn(description);

        header.write(level.toString(),title);

        verify(fileWriterMock).writeLine(description + "{" + title + "}");
    }

    @Test
    void floatBarrierTest() {
        Integer level = 1;
        String title = GetRandomString();
        String description = GetRandomString();
        when(latexDivisionMock.header(level)).thenReturn(description);

        header.write(level.toString(),title);

        verify(fileWriterMock).writeLine("\\FloatBarrier");
    }

    @Test
    void writeStringAsteriskTest() {
        Integer level = 1;
        String title = GetRandomString();
        String description = GetRandomString();
        when(latexDivisionMock.header(level)).thenReturn(description);

        header.write(level +"*",title);

        verify(fileWriterMock).writeLine(description + "*" +"{" + title + "}");
    }



}
