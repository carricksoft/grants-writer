/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.sections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonSubSectionReferencesWriterTest {

    private PersonSubSectionReferencesWriter writer;

    @Mock
    private LatexSubSectionHeader latexSubSectionHeaderMock;

    @BeforeEach
    void setUp() {
        writer = new PersonSubSectionReferencesWriterImpl(latexSubSectionHeaderMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(writer);
    }
}