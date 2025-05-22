/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class WritePartsTest {

    private WriteParts writeParts;

    @BeforeEach
    void setUp() {
        writeParts = new WritePartsImpl();
    }

    @Test
    void constructorTest(){
        assertNotNull(writeParts);
    }
}