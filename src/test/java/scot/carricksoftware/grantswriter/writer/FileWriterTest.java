/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}