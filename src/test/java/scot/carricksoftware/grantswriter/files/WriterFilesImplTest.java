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