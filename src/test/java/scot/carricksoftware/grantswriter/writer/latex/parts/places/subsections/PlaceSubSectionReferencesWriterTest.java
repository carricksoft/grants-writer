/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections;

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
class PlaceSubSectionReferencesWriterTest {

    private PlaceSubSectionReferencesWriter placeSubSectionReferencesWriter;

    @Mock
    private LatexSubSectionHeader latexSubSectionHeaderMock;
    @Mock
    private WriteReferences writeReferencesMock;

    @BeforeEach
    void setUp() {
        placeSubSectionReferencesWriter = new PlaceSubSectionReferencesWriterImpl(latexSubSectionHeaderMock, writeReferencesMock);
    }

    @Test
    void writeTest() {
        InOrder inOrder = inOrder(latexSubSectionHeaderMock, writeReferencesMock);

        placeSubSectionReferencesWriter.write();
        inOrder.verify(latexSubSectionHeaderMock).write("References");
        inOrder.verify(writeReferencesMock).write();
    }

}