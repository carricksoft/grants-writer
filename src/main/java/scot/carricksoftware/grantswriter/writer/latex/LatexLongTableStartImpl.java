/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.writer.FileWriter;

@Component
public class LatexLongTableStartImpl implements LatexLongTableStart {

    private final FileWriter fileWriter;

    public LatexLongTableStartImpl(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void write(String columns) {
        String sb = LatexConstants.LONG_TABLE_START +
                columns +
                LatexConstants.TERM_END;
        fileWriter.writeLine(sb);
    }
}
