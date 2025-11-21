/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.AppendixPartWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.document.DocumentPartWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.PeoplePartWriter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.inOrder;

@ExtendWith(SpringExtension.class)
class PartsWriterTest {

    private PartsWriter partsWriter;

    @Mock
    PeoplePartWriter peoplePartWriterMock;
    @Mock
    AppendixPartWriter appendixPartWriterMock;
    @Mock
    DocumentPartWriter documentPartWriterMock;

    @BeforeEach
    void setUp() {
        partsWriter = new PartsWriterImpl(peoplePartWriterMock, appendixPartWriterMock, documentPartWriterMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(partsWriter);
    }

    @Test
    void writeTest() {
        InOrder inorder = inOrder(documentPartWriterMock, peoplePartWriterMock, appendixPartWriterMock);
        partsWriter.write();
        inorder.verify(documentPartWriterMock).write();
        inorder.verify(peoplePartWriterMock).write();
        inorder.verify(appendixPartWriterMock).write();

    }
}
