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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class LatexDocumentEndTest {

    private LatexDocumentEnd documentEnd;

    @Mock
    private FileWriter fileWriterMock;

    @BeforeEach
    void setUp() {
        documentEnd = new LatexDocumentEndImpl(fileWriterMock);
    }

    @Test
    public void constructorTest() {
        assertNotNull(documentEnd);
    }

    @Test
    public void writeTest() {
        documentEnd.write();
        verify(fileWriterMock).writeLine("\\end{document}");
    }
}