/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class WriteBaseTextTest {

    private WriteBaseText writeBaseText;

    @BeforeEach
    void setUp() {
        writeBaseText = new WriteBaseTextImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(writeBaseText);
    }

}