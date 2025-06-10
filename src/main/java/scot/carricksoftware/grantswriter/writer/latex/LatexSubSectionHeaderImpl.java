/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.writer.FileWriter;

@Component
public class LatexSubSectionHeaderImpl implements LatexSubSectionHeader {

    private final FileWriter fileWriter;

    public LatexSubSectionHeaderImpl(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void write(String title) {
        String sb = LatexConstants.SUBSECTION_TERM +
                title +
                LatexConstants.TERM_END;
        fileWriter.writeLine(sb);
    }
}
