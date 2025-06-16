/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.writer.FileWriter;

import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class LatexPackageDeclarationTest {

    private LatexPackageDeclaration latexPackageDeclaration;

    @Mock
    private FileWriter fileWriterMock;

    @BeforeEach
    void setUp() {
        latexPackageDeclaration = new LatexPackageDeclarationImpl(fileWriterMock);
    }

    @Test
    void writeTest() {
        String packageName = GetRandomString();
        @SuppressWarnings("SpellCheckingInspection") String required = "\\usepackage{" + packageName + "}";
        latexPackageDeclaration.write(packageName);
        verify(fileWriterMock).writeLine(required);
    }
}