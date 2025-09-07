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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class LatexSubSectionHeaderTest {

    private LatexSubSectionHeader header;

    @Mock
    private FileWriter fileWriterMock;

    @Mock
    private LatexDivision latexDivisionMock;

    @BeforeEach
    void setUp() {
        header = new LatexSubSectionHeaderImpl(fileWriterMock, latexDivisionMock);
    }

    @Test
    void writeTest() {
        when(latexDivisionMock.header(any())).thenReturn("\\subsection{");
        String title = GetRandomString();
        header.write(title);
        String requiredString = "\\subsection{" + title + "}";
        verify(fileWriterMock).writeLine(requiredString);
    }
}