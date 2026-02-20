/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.headers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.writer.latex.LatexPartHeader;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PartsPartHeaderTest {

    private PlacesPartHeader placesPartsHeader;

    @Mock
    LatexPartHeader latexPartHeaderMock;


    @BeforeEach
    public void setUp() {
        placesPartsHeader = new PlacesPartHeaderImpl(latexPartHeaderMock);
    }

    @Test
    public void latexPartHeaderIsCalledTest() {
        placesPartsHeader.write();
        verify(latexPartHeaderMock).write("Places");
    }

}