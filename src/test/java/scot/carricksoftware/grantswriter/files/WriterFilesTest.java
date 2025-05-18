/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WriterFilesTest {

    private WriterFiles writerFiles;

    @BeforeEach
    void setUp() {
        writerFiles = new WriterFilesImpl();
    }

    @Test
    public void setUpTest() {
        assertNotNull(writerFiles);
    }
}