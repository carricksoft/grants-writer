/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.data.helpers.LatexDivision;
import scot.carricksoftware.grantswriter.writer.FileWriter;

import static scot.carricksoftware.grantswriter.constants.LatexLevels.LATEX_PART;

@Component
public class LatexPartHeaderImpl implements LatexPartHeader {


    private final FileWriter fileWriter;

    private final LatexDivision latexDivision;

    public LatexPartHeaderImpl(FileWriter fileWriter, LatexDivision latexDivision) {
        this.fileWriter = fileWriter;
        this.latexDivision = latexDivision;
    }

    @Override
    public void write(String title) {
        String sb = latexDivision.header(LATEX_PART) +
                title +
                LatexConstants.TERM_END;
        fileWriter.writeLine(sb);
    }
}
