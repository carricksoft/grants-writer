/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data.helpers;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_BOOK;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_CHAPTER;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_PARAGRAPH;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_PART;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_SECTION;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_SUBPARAGRAPH;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_SUBSECTION;
import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_SUB_SUBSECTION;

@Component
public class LatexDivisionImpl implements  LatexDivision {

    private final Map<Integer, String> headers;

    public LatexDivisionImpl() {
        headers = new HashMap<>();
        headers.put(LATEX_BOOK, "\\book");
        headers.put(LATEX_PART, "\\part");
        headers.put(LATEX_CHAPTER, "\\chapter");
        headers.put(LATEX_SECTION, "\\section");
        headers.put(LATEX_SUBSECTION, "\\subsection");
        headers.put(LATEX_SUB_SUBSECTION, "\\subsubsection");
        headers.put(LATEX_PARAGRAPH, "\\paragraph");
        headers.put(LATEX_SUBPARAGRAPH, "\\subparagraph");
    }

    @Override
    public String header(Integer level) {
        String result = headers.get(level);
        if (result == null) {
            throw new RuntimeException("No header found for level " + level);
        }
        return result;
    }
}
