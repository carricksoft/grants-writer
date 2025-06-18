/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTabLeEnd;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTableStart;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
class WriteReferencesTest {

    private WriteReferences writeReferences;

    private final SortedSet<String> references = new TreeSet<>();

    @Mock
    private FileWriter fileWriterMock;

    @Mock
    private LatexLongTableStart latexLongTableStartMock;

    @Mock
    private LatexLongTabLeEnd latexLongTabLeEndMock;

    @BeforeEach
    void setUp() {
        writeReferences = new WriteReferencesImpl(fileWriterMock, latexLongTableStartMock, latexLongTabLeEndMock);
    }

    @Test
    void writeTest() {
        InOrder inorder = inOrder(latexLongTableStartMock, latexLongTabLeEndMock);
        writeReferences.write(references);
        inorder.verify(latexLongTableStartMock).write("l");
        inorder.verify(latexLongTabLeEndMock).write();
    }
}