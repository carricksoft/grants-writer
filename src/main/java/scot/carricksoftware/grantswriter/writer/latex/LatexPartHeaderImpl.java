/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.writer.FileWriter;

@Component
public class LatexPartHeaderImpl implements LatexPartHeader {


    private final FileWriter fileWriter;

    public LatexPartHeaderImpl(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }


    @Override
    public void write(String title) {
        String sb = LatexConstants.PART_TERM +
                title +
                LatexConstants.TERM_END;
        fileWriter.writeLine(sb);
    }
}
