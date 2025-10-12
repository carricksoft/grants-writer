/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.converters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.DatatypeConverter;

import java.io.File;
import java.io.FileInputStream;

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

    @Test
    void anExceptionIsThrownTest() {
        assertThrows(Exception.class, () -> converter.convert(GetRandomString(), null));
    }

    @Test
    void aCorrectFileIsCreatedTest() {
        String testString = "Hello World!";
        byte[] testBytes = DatatypeConverter.parseBase64Binary(testString);
        converter.convert(testString, fileName);

        byte[] result = readFileToBytes();
        assertArrayEquals(testBytes, result);
    }


    @SuppressWarnings("AssertWithSideEffects")
    @AfterEach
    void tearDown() {
        File f1 = new File(fileName);
        assert !f1.exists() || (f1.delete());
    }

    private byte[] readFileToBytes() {
// from https://stackoverflow.com/questions/858980/file-to-byte-in-java
        File file = new File(fileName);
        byte[] bytes = new byte[(int) file.length()];

        try (FileInputStream fis = new FileInputStream(file)) {
            //noinspection ResultOfMethodCallIgnored
            fis.read(bytes);
            return bytes;
        } catch (Exception ignored) {

        }
        return null;

    }


}