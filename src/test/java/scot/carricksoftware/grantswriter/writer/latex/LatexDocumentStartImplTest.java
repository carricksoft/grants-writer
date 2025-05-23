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

@ExtendWith(SpringExtension.class)
class LatexDocumentStartImplTest {

    private LatexDocumentStart documentStart;

    @Mock
    private FileWriter fileWriterMock ;

    @BeforeEach
    void setUp() {
        documentStart = new LatexDocumentStartImpl(fileWriterMock);
    }

    @Test
    public void constructorTest() {
        assertNotNull(documentStart);
    }
}