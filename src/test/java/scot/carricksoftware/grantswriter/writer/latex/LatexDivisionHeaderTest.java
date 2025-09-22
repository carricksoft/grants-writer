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
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomInteger;

@ExtendWith(MockitoExtension.class)
class LatexDivisionHeaderTest {

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
        Integer level = GetRandomInteger();
        String title = GetRandomString();
        String heading = GetRandomString();
        when(latexDivisionMock.header(level)).thenReturn(heading);
        String requiredString = heading + title + "}";
        header.write(level, title);

        verify(fileWriterMock).writeLine(requiredString);
    }

    @Test
    void writeStringTest() {
        Integer level = GetRandomInteger();
        String levelString = level.toString();
        String title = GetRandomString();
        String heading = GetRandomString();
        when(latexDivisionMock.header(level)).thenReturn(heading);
        String requiredString = heading + title + "}";
        header.write(levelString, title);

        verify(fileWriterMock).writeLine(requiredString);
    }

}