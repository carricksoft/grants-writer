/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LatexSectionHeaderTest {

   private LatexSectionHeader header;

    @BeforeEach
    void setUp() {
        header = new LatexSectionHeaderImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(header);
    }
}