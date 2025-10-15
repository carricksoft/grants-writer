/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.WriteReferences;


import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
class PersonSubSectionReferencesWriterTest {

    private PersonSubSectionReferencesWriter personSubSectionReferencesWriter;

    @Mock
    private LatexSubSectionHeader latexSubSectionHeaderMock;
    @Mock
    private WriteReferences writeReferencesMock;

    @BeforeEach
    void setUp() {
        personSubSectionReferencesWriter = new PersonSubSectionReferencesWriterImpl(latexSubSectionHeaderMock, writeReferencesMock);
    }

    @Test
    void writeTest() {
        InOrder inOrder = inOrder(latexSubSectionHeaderMock, writeReferencesMock);

        personSubSectionReferencesWriter.write();
        inOrder.verify(latexSubSectionHeaderMock).write("References");
        inOrder.verify(writeReferencesMock).write();
    }
}