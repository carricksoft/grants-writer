/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.LatexLevels;


@Component
public class LatexSubSectionHeaderImpl implements LatexSubSectionHeader {

    private final LatexDivisionHeader latexDivisionHeader;

    public LatexSubSectionHeaderImpl(LatexDivisionHeader latexDivisionHeader) {
        this.latexDivisionHeader = latexDivisionHeader;
    }


    @Override
    public void write(String title) {
        latexDivisionHeader.write(LatexLevels.LATEX_SUBSECTION, title);
    }
}
