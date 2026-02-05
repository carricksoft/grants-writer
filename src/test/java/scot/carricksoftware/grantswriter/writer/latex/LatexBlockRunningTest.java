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
class LatexBlockRunningTest {

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
    void endRunningRunningBlockTest() {
        String expected = "\\end{" + blockName + "}";
        latexBlock.endRunningBlock(blockName);
        verify(fileWriterMock).writeLine(expected);
    }

    @Test
    void beginRunningBlockNullTest() {
        String expected = "\\begin{" + blockName + "}";
        latexBlock.beginRunningBlock(blockName, null);
        verify(fileWriterMock).writeLine(expected);
    }

    @Test
    void beginRunningBlockEmptyOptionsTest() {
        String expected = "\\begin{" + blockName +"}";
        latexBlock.beginRunningBlock(blockName, "");
        verify(fileWriterMock).writeLine(expected);
    }

    @Test
    void beginRunningBlockOptionsTest() {
        String options = GetRandomString();
        String expected = "\\begin{" + blockName + "}[" + options + "]";
        latexBlock.beginRunningBlock(blockName, options);
        verify(fileWriterMock).writeLine(expected);
    }
}