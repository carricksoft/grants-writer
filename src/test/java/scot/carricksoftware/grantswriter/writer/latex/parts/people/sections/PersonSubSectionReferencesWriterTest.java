/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.sections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.PersonSubSectionReferencesWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.PersonSubSectionReferencesWriterImpl;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.WriteReferences;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonSubSectionReferencesWriterTest {

    private PersonSubSectionReferencesWriter writer;

    @Mock private LatexSubSectionHeader latexSubSectionHeaderMock;
    @Mock private WriteReferences writeReferencesMock;

    @BeforeEach
    void setUp() {
        writer = new PersonSubSectionReferencesWriterImpl(latexSubSectionHeaderMock, writeReferencesMock);
    }

    @Test
    void writeTest() {
        writer.write();
        verify(latexSubSectionHeaderMock).write("References");
    }
}