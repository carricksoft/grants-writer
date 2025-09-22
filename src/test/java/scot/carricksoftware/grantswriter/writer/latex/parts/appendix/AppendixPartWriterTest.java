/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.appendix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.writer.latex.LatexPartHeader;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AppendixPartWriterTest {

    private AppendixPartWriter writer;

    @Mock
    private LatexPartHeader latexPartHeaderMock;

    @BeforeEach
    void setUp() {
        writer = new AppendixPartWriterImpl(latexPartHeaderMock);
    }

    @Test
    void constructorTest(){
        assertNotNull(writer);
    }
}