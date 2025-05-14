/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;

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

    @Test
    void initTest() {
        writerFiles.init();
        assertEquals(System.getProperty("user.home") + File.separator + "carricksoftware" + File.separator + "grants.tex",
                writerFiles.getLatexFileName());
        assertEquals(System.getProperty("user.home") + File.separator + "carricksoftware" + File.separator + "grants.pdf",
                writerFiles.getPdfFileName());
    }
}