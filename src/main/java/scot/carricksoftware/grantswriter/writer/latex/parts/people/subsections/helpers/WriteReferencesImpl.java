/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexItemizeStart;
import scot.carricksoftware.grantswriter.writer.latex.LatexItemizeEnd;

import java.util.SortedSet;

@Component
public class WriteReferencesImpl implements WriteReferences {

    private static final Logger logger = LogManager.getLogger(WriteReferencesImpl.class);

    private final FileWriter fileWriter;
    private final TimeLineData timeLineData;
    private final LatexItemizeStart latexItemizeStart;
    private final LatexItemizeEnd latexItemizeEnd;

    public WriteReferencesImpl(FileWriter fileWriter,
                               TimeLineData timeLineData,
                               LatexItemizeStart latexItemizeStart,
                               LatexItemizeEnd latexItemizeEnd) {
        this.fileWriter = fileWriter;
        this.timeLineData = timeLineData;
        this.latexItemizeStart = latexItemizeStart;
        this.latexItemizeEnd = latexItemizeEnd;
    }

    @Override
    public void write() {
        logger.info("WriteReferences::write");
        SortedSet<String> references = timeLineData.getRefs();
        if (!references.isEmpty()) {
            latexItemizeStart.write();
            writeTheData(references);
            latexItemizeEnd.write();
        }
    }

    private void writeTheData(  SortedSet<String> references) {
        logger.info("WriteReferences::writeTheData");
        for (String reference : references) {
            String line = LatexConstants.ITEM + " " + reference;
            fileWriter.writeLine(line);
        }
    }
}
