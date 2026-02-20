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
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.writer.latex.LatexSectionHeader;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class PlaceSectionHeaderTest {

    private PlaceSectionHeader placeSectionHeader;

    @Mock
    LatexSectionHeader latexSectionHeaderMock;

    @Mock
    Place placeMock;

    @BeforeEach
    public void setUp() {
        placeSectionHeader = new PlaceSectionHeaderImpl(latexSectionHeaderMock);
    }

    @Test
    public void latexSectionHeaderIsCalledTest() {
        String heading = GetRandomString();
        when(placeMock.toString()).thenReturn(heading);
        placeSectionHeader.write(placeMock);
        verify(latexSectionHeaderMock).write(heading);
    }

}