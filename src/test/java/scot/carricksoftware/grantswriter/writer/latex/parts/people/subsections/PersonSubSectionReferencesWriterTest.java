/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class PersonSubSectionReferencesWriterTest {

    private PersonSubSectionReferencesWriter personSubSectionReferencesWriter;

    @Mock
    private LatexSubSectionHeader latexSubSectionHeaderMock;

    @BeforeEach
    void setUp() {
        personSubSectionReferencesWriter = new PersonSubSectionReferencesWriterImpl(latexSubSectionHeaderMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(personSubSectionReferencesWriter);
    }
}