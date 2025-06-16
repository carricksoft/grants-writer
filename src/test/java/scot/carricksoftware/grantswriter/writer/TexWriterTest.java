/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.writer.latex.LatexDocumentEnd;
import scot.carricksoftware.grantswriter.writer.latex.LatexDocumentStart;
import scot.carricksoftware.grantswriter.writer.latex.parts.PartsWriter;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.inOrder;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class TexWriterTest {

    private TexWriter texWriter;

    @Mock
    private FileWriter fileWriterMock;

    @Mock
    private LatexDocumentStart docStartMock;

    @Mock
    private LatexDocumentEnd docEndMock;

    @Mock
    private PartsWriter partsWriterMock;

    @BeforeEach
    void setUp() {
        texWriter = new TexWriterImpl(fileWriterMock, docStartMock, docEndMock, partsWriterMock);
    }

    @Test
    void writeTest() throws Exception {
        InOrder inorder = inOrder(fileWriterMock, docStartMock, docEndMock, partsWriterMock, fileWriterMock);
        texWriter.write(GetRandomString());

        inorder.verify(fileWriterMock).init(anyString());
        inorder.verify(docStartMock).write();
        inorder.verify(partsWriterMock).write();
        inorder.verify(docEndMock).write();
        inorder.verify(fileWriterMock).close();
    }

}