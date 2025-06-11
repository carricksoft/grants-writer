/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.writer.latex.parts.LatexLongTabLeEnd;
import scot.carricksoftware.grantswriter.writer.latex.parts.LatexLongTabLeEndImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class LatexLongTabLeEndTest {


    private LatexLongTabLeEnd latexLongTabLeEnd;

    @BeforeEach
    void setUp() {
        latexLongTabLeEnd = new LatexLongTabLeEndImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(latexLongTabLeEnd);
    }
}