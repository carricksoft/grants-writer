/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LatexLongTableStartTest {

    private LatexLongTableStart latexLongTableStart;

    @BeforeEach
    void setUp() {
        latexLongTableStart = new LatexLongTableStartImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(latexLongTableStart);
    }
}