/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomString;


class FileWriterTest {

    private FileWriter writer;

    @BeforeEach
    void setUp() {
        writer = new FileWriterImpl();
    }

    @Test
    void getOsTest(){
        assertNull(writer.getOs());
    }

    @Test
    void initTest() throws Exception {
        writer.init(GetRandomString());
        assertNotNull(writer.getOs());
    }

    @Test
    void closeTest() throws Exception {
        writer.init(GetRandomString());
        writer.close();
        assertNull(writer.getOs());
    }

    @Test
    void writeTest() throws Exception {
        File file = File.createTempFile("/tmp", ".tmp");
        String line = GetRandomString();
        writer.init(file.getAbsolutePath());
        writer.writeLine(line);
        writer.writeLine(line);
        writer.close();

        assertEquals(line + line, getFileContents(file.getAbsolutePath()));
    }

    private String getFileContents(String fileName) throws IOException {
        Scanner in = new Scanner(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        while(in.hasNext()) {
            sb.append(in.next());
        }
        in.close();
        return sb.toString();
    }
}