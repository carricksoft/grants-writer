/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import scot.carricksoftware.grantswriter.writer.FileWriter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.inOrder;

@SuppressWarnings("SpellCheckingInspection")
@ExtendWith(SpringExtension.class)
class LatexDocumentStartTest {

    private LatexDocumentStart documentStart;

    @Mock
    private FileWriter fileWriterMock;
    @Mock
    private LatexPackageDeclaration latexPackageDeclarationMock;

    @BeforeEach
    void setUp() {
        documentStart = new LatexDocumentStartImpl(fileWriterMock, latexPackageDeclarationMock);
    }

    @Test
    public void constructorTest() {
        assertNotNull(documentStart);
    }

    @Test
    public void writeTest() {
        InOrder inorder = inOrder(fileWriterMock,
                latexPackageDeclarationMock,
                fileWriterMock,
                fileWriterMock,
                fileWriterMock);
        documentStart.write();

        inorder.verify(fileWriterMock).writeLine("\\documentclass[a4paper,11pt, twoside]{memoir}");
        inorder.verify(latexPackageDeclarationMock).write("longtable", "");
        inorder.verify(latexPackageDeclarationMock).write("adjustbox", "export");
        inorder.verify(latexPackageDeclarationMock).write("placeins", "");
        inorder.verify(fileWriterMock).writeLine("\\setsecnumdepth{subsubsection}");
        inorder.verify(fileWriterMock).writeLine("\\begin{document}");
    }

}