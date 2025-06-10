/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.headers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.writer.latex.LatexPartHeader;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PeoplePartWriterHeaderTest {

    private PeoplePartHeader header;

    @Mock
    private LatexPartHeader latexPartHeaderMock;

    @BeforeEach
    void setUp() {
        header = new PeoplePartHeaderImpl(latexPartHeaderMock);
    }

    @Test
    void writeTest() {
        header.write();
        verify(latexPartHeaderMock).write("People");
    }
}