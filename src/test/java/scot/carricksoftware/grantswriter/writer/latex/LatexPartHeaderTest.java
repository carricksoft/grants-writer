/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import scot.carricksoftware.grantswriter.writer.FileWriter;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class LatexPartHeaderTest {

    private LatexPartHeader header;

    @Mock
    private FileWriter fileWriterMock;

    @BeforeEach
    void setUp() {
        header = new LatexPartHeaderImpl(fileWriterMock);
    }

    @Test
    void ConstructorTest() {
       assertNotNull(header);
    }
}
