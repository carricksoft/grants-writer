/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomString;

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



}