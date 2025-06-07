/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import scot.carricksoftware.grantswriter.writer.latex.LatexPartHeader;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PeoplePartWriterHeaderTest {

    private PeoplePartHeader header;

    @Mock
    private LatexPartHeader latexPartHeaderMock;

    @BeforeEach
    void setUp() {
        header = new PeoplePartHeaderImpl(latexPartHeaderMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(header);
    }

}