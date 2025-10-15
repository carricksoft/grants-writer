/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.appendix.headers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.writer.latex.LatexPartHeader;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AppendixPartHeaderTest {

    private AppendixPartHeader appendixPartHeader;

    @Mock
    private LatexPartHeader latexPartHeaderMock;

    @BeforeEach
    void setUp() {
        appendixPartHeader = new AppendixPartHeaderImpl(latexPartHeaderMock);
    }

    @Test
    void theCorrectHeaderIsWrittenTest() {
        appendixPartHeader.write();
        verify(latexPartHeaderMock).write("Appendix");
    }
}