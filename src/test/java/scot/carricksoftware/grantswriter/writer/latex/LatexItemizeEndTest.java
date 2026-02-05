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

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class LatexItemizeEndTest {

    private LatexItemizeEnd latexItemizeEnd;

    @Mock
    private LatexBlock latexBlockMock;

    @BeforeEach
    void setUp() {
        latexItemizeEnd = new LatexItemizeEndImpl(latexBlockMock);
    }

    @Test
    void writeTest() {
        latexItemizeEnd.write();
        verify(latexBlockMock).endRunningBlock("itemize");
    }
}