/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.converters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.codehaus.plexus.util.FileUtils.fileExists;
import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

class StringToFileConverterTest {

    private StringToFileConverter converter;

    private final String fileName = "file.test";

    @BeforeEach
    void setUp() {
        converter = new StringToFileConverterImpl();
    }

    @Test
    void aFileIsCreatedTest() {
        converter.convert(GetRandomString(), fileName);
        assertTrue(fileExists(fileName));
    }

    @SuppressWarnings("AssertWithSideEffects")
    @AfterEach
    void tearDown() {
        File f1 = new File(fileName);
        assert !f1.exists() || (f1.delete());
    }


}