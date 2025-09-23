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
import scot.carricksoftware.grantswriter.writer.FileWriter;

import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class LatexLongTableStartTest {

    private LatexLongTableStart latexLongTableStart;

    @Mock private FileWriter fileWriterMock;

    @BeforeEach
    void setUp() {
        latexLongTableStart = new LatexLongTableStartImpl(fileWriterMock);
    }

    @Test
    void writeTest() {
        String columns = GetRandomString();
        @SuppressWarnings("SpellCheckingInspection") String required = "\\begin{longtable}{" + columns + "}";
        latexLongTableStart.write(columns);
        verify(fileWriterMock).writeLine(required);
    }
}