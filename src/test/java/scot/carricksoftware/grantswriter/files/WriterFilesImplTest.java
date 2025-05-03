/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WriterFilesImplTest {

    private WriterFiles writerFiles;

    @BeforeEach
    void setUp() {
        writerFiles = new WriterFilesImpl();
    }

    @Test
    void getDirectoryTest() {
        assertNull(writerFiles.getDirectory());
    }

    @Test
    void setDirectoryTest() {
        String string = "test";
        writerFiles.setDirectory(string);
    }

    @Test
    void getInputFileNameTest() {
        assertNull(writerFiles.getInputFileName());
    }

    @Test
    void setInputFileNameTest() {
        String string = "test";
        writerFiles.setInputFileName(string);
        assertEquals(string, writerFiles.getInputFileName());
    }

    @Test
    void getLatexFileNameTest() {
        assertNull(writerFiles.getLatexFileName());
    }

    @Test
    void setLatexFileNameTest() {
        String string = "test";
        writerFiles.setLatexFileName(string);
        assertEquals(string, writerFiles.getLatexFileName());
    }

    @Test
    void getPdfFileNameTest() {
        assertNull(writerFiles.getPdfFileName());
    }

    @Test
    void setPdfFileNameTest() {
        String string = "test";
        writerFiles.setPdfFileName(string);
        assertEquals(string, writerFiles.getPdfFileName());
    }
}