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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LatexPackageDeclarationTest {

    private LatexPackageDeclaration latexPackageDeclaration;

    @Mock
    private  FileWriter fileWriterMock;



    @BeforeEach
    void setUp() {
        latexPackageDeclaration = new LatexPackageDeclarationImpl(fileWriterMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(latexPackageDeclaration);
    }
}