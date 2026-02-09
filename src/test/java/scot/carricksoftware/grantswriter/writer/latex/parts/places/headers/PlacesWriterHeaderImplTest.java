/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.headers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import scot.carricksoftware.grantswriter.writer.latex.LatexPartHeader;

import static org.mockito.Mockito.verify;

class PlacesWriterHeaderImplTest {

    private PlacesPartHeader header;

    @Mock
    private LatexPartHeader latexPartHeaderMock;

    @BeforeEach
    void setUp() {
        header = new PlacesPartHeaderImpl(latexPartHeaderMock);
    }

    @Test
    void writeTest() {
        header.write();
        verify(latexPartHeaderMock).write("Places");
    }
}