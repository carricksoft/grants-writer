/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


class FileWriterTest {

    private FileWriter writer;

    @BeforeEach
    void setUp() {
        writer = new FileWriterImpl();
    }

    @Test
    public void GetPrintWriterTest() {
        assertNull(writer.getPrintWriter());
    }

    @Test
    public void initTest() throws Exception {
        writer.init(GetRandomString());
        assertNotNull(writer.getPrintWriter());
    }

    @Test
    public void closeTest() throws Exception {
        writer.init(GetRandomString());
        writer.close();
        assertNull(writer.getPrintWriter());
    }

    @Test
    public void writeLineTest() throws Exception {
       String tempFileName = getTemporaryFileName();
       deleteTempFile(tempFileName);
       String line = GetRandomString();

       writer.init(tempFileName);
       writer.writeLine(line);
       writer.close();

       List<String> contents = getTempFileContents(tempFileName);
        assertEquals(line, contents.get(0));
    }

    private List<String> getTempFileContents(String tempFileName) throws Exception {
        return Files.readAllLines(Paths.get(tempFileName));
    }

    private void deleteTempFile(String tempFileName) {
        File file = new File(tempFileName);
        //noinspection ResultOfMethodCallIgnored
        file.delete();
    }

    private String getTemporaryFileName() throws Exception {
        File file = File.createTempFile("/tmp", "tmp");
        return file.getAbsolutePath();
    }


}