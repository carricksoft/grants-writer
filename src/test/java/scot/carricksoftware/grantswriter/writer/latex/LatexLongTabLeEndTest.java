/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import scot.carricksoftware.grantswriter.writer.FileWriter;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension .class)
class LatexLongTabLeEndTest {

    private LatexLongTabLeEnd latexLongTabLeEnd;

    @Mock
    private FileWriter fileWriterMock;

    @BeforeEach
    void setUp() {
        latexLongTabLeEnd = new LatexLongTabLeEndImpl(fileWriterMock);
    }

    @Test
    void writeTest() {
        latexLongTabLeEnd.write();
        //noinspection SpellCheckingInspection
        verify(fileWriterMock).writeLine("\\end{longtable}");
    }
}