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
class LatexBlockTest {

    private LatexBlock latexBlock;

    @Mock
    private FileWriter fileWriterMock;

    private String blockName;

    @BeforeEach
    void setUp() {
        latexBlock = new LatexBlockImpl(fileWriterMock);
        blockName = GetRandomString();
    }

    @Test
    void endTest() {
       String expected = "}\\end{" + blockName + "}";
       latexBlock.end(blockName);
       verify(fileWriterMock).writeLine( expected);
    }

    @Test
    void beginNullOptionsTest() {
        String expected = "\\begin{" + blockName + "}{";
        latexBlock.begin(blockName, null);
        verify(fileWriterMock).writeLine( expected);
    }

    @Test
    void beginEmptyOptionsTest() {
        String expected = "\\begin{" + blockName + "}{";
        latexBlock.begin(blockName, "");
        verify(fileWriterMock).writeLine( expected);
    }

    @Test
    void beginOptionsTest() {
        String options = GetRandomString();
        String expected = "\\begin{" + blockName + "}[" + options  + "]{";
        latexBlock.begin(blockName, options);
        verify(fileWriterMock).writeLine( expected);
    }
}