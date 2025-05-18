/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WriterFilesImplTest {

    private WriterFiles writerFiles;

    @BeforeEach
    void setUp() {
        writerFiles = new WriterFilesImpl();
    }

    @Test
    void constructorTest() {
        assertNull(writerFiles.getLatexFileName());
        assertNull(writerFiles.getPdfFileName());
    }



}