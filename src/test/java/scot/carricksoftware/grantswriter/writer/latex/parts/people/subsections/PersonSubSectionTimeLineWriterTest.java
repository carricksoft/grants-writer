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
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.WriteTimeLine;

import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
class PersonSubSectionTimeLineWriterTest {

    private PersonSubSectionTimeLineWriter writer;

    @Mock
    private LatexSubSectionHeader latexSubSectionHeaderMock;

    @Mock
    private WriteTimeLine writeTimeLineMock;

    @BeforeEach
    void setUp() {
        writer = new PersonSubSectionTimeLineWriterImpl(
                latexSubSectionHeaderMock,
                writeTimeLineMock);
    }

    @Test
    void writeHeaderTest() {
        InOrder inOrder = inOrder(latexSubSectionHeaderMock, writeTimeLineMock);

        writer.write();
        inOrder.verify(latexSubSectionHeaderMock).write("Timeline");
        inOrder.verify(writeTimeLineMock).write();
    }


}