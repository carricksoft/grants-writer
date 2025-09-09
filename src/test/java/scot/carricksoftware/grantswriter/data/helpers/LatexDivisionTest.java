/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_BOOK;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_CHAPTER;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_PARAGRAPH;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_PART;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_SECTION;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_SUBPARAGRAPH;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_SUBSECTION;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_SUB_SUBSECTION;

class LatexDivisionTest {

    private LatexDivision latexDivision;

    private Map<Integer, String> headers;

    @BeforeEach
    void setUp() {
        latexDivision = new LatexDivisionImpl();
        headers = new HashMap<>();
        headers.put(LATEX_BOOK, "\\book{");
        headers.put(LATEX_PART, "\\part{");
        headers.put(LATEX_CHAPTER, "\\chapter{");
        headers.put(LATEX_SECTION, "\\section{");
        headers.put(LATEX_SUBSECTION, "\\subsection{");
        //noinspection SpellCheckingInspection
        headers.put(LATEX_SUB_SUBSECTION, "\\subsubsection{");
        headers.put(LATEX_PARAGRAPH, "\\paragraph{");
        headers.put(LATEX_SUBPARAGRAPH, "\\subparagraph{");
    }

    @Test
    void validTest() {
        for (int i = LATEX_BOOK; i <= LATEX_SUBPARAGRAPH; i++) {
            assertEquals(headers.get(i), latexDivision.header(i));
        }
    }

    @Test
    void lowLevelThrowsAnExceptionTest() {
        assertThrows(RuntimeException.class, () -> latexDivision.header(LATEX_BOOK - 1));
    }

    @Test
    void highLevelThrowsAnExceptionTest() {
        assertThrows(RuntimeException.class, () -> latexDivision.header(LATEX_SUBPARAGRAPH + 1));
    }
}