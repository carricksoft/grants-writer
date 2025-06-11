/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.writer.FileWriter;

public class LatexLongTabLeEndImpl implements LatexLongTabLeEnd {

    private final FileWriter fileWriter;

    public LatexLongTabLeEndImpl(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }


    @Override
    public void write() {
        fileWriter.writeLine(LatexConstants.LONG_TABLE_END);
    }
}
