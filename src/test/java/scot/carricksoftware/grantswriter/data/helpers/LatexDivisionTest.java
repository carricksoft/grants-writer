/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_BOOK;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_SUBPARAGRAPH;

class LatexDivisionTest {

    private LatexDivision latexDivision;

    @BeforeEach
    void setUp() {
        latexDivision = new LatexDivisionImpl();
    }

    @Test
    void lowLevelThrowsAnExceptionTest() {
        assertThrows(RuntimeException.class, () -> latexDivision.header(LATEX_BOOK - 1));
    }

    @Test
    void highLevelThrowsAnExceptionTest() {
        assertThrows(RuntimeException.class, () -> latexDivision.header(LATEX_SUBPARAGRAPH + 1));
    }

    @Test
    void sectionTest() {
        assertEquals("\\section", latexDivision.header(1));
    }
}