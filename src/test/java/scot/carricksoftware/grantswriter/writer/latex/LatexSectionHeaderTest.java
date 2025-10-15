/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class LatexSectionHeaderTest {

    private LatexSectionHeader header;

    @Mock
    private LatexDivisionHeader latexDivisionHeaderMock;

    @BeforeEach
    void setUp() {
        header = new LatexSectionHeaderImpl(latexDivisionHeaderMock);
    }

    @Test
    void writeTest() {
        String title = GetRandomString();
        header.write(title);
        verify(latexDivisionHeaderMock).write(1, title);
    }
}