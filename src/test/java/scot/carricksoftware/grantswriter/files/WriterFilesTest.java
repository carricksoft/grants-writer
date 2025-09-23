/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


class WriterFilesTest {

    private WriterFiles writerFiles;

    @BeforeEach
    void setUp() {
        writerFiles = new WriterFilesImpl();
    }

    @Test
    public void getLatexFileNameTest() {
        assertNull(writerFiles.getLatexFileName());
    }

    @Test
    public void SetLatexFileNameTest() {
        String string = GetRandomString();
        writerFiles.setLatexFileName(string);
        assertEquals(string, writerFiles.getLatexFileName());
    }

    @Test
    public void getPdfFileNameTest() {
        assertNull(writerFiles.getPdfFileName());
    }

    @Test
    public void SetPdfFileNameTest() {
        String string = GetRandomString();
        writerFiles.setPdfFileName(string);
        assertEquals(string, writerFiles.getPdfFileName());
    }

    @Test
    public void getStatusTest() {
        assertNull(writerFiles.getStatus());
    }

    @Test
    public void SetStatusTest() {
        String string = GetRandomString();
        writerFiles.setStatus(string);
        assertEquals(string, writerFiles.getStatus());
    }

    @Test
    public void InitTest() {
        writerFiles.init();
        assertEquals("Ready", writerFiles.getStatus());
        assertTrue(writerFiles.getLatexFileName().contains("grants.tex"));
        assertTrue(writerFiles.getPdfFileName().contains("grants.pdf"));
    }
}