/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTabLeEnd;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTableStart;

import java.util.SortedSet;

public class WriteReferencesImpl implements WriteReferences {

    private static final Logger logger = LogManager.getLogger(WriteReferencesImpl.class);

    private final FileWriter fileWriter;
    private final LatexLongTableStart latexLongTableStart;
    private final LatexLongTabLeEnd latexLongTabLeEnd;

    public WriteReferencesImpl(FileWriter fileWriter,
                               LatexLongTableStart latexLongTableStart,
                               LatexLongTabLeEnd latexLongTabLeEnd) {
        this.fileWriter = fileWriter;
        this.latexLongTableStart = latexLongTableStart;
        this.latexLongTabLeEnd = latexLongTabLeEnd;
    }

    @Override
    public void write(SortedSet<String> references) {
        logger.info("WriteReferences::write");

        latexLongTableStart.write("l");
        writeTheData(references);
        latexLongTabLeEnd.write();
    }

    private void writeTheData(SortedSet<String> references) {
        logger.info("WriteReferences::writeTheData");
        for (String reference : references) {
            String line =
                    reference + LatexConstants.TABLE_LINE_END;
            fileWriter.writeLine(line);
        }
    }
}
