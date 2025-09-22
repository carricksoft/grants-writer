/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.data.helpers.LatexDivision;
import scot.carricksoftware.grantswriter.writer.FileWriter;

@Component
public class LatexDivisionHeaderImpl implements LatexDivisionHeader {

    private static final Logger logger = LogManager.getLogger(LatexDivisionHeaderImpl.class);

    private final FileWriter fileWriter;

    private final LatexDivision latexDivision;

    public LatexDivisionHeaderImpl(FileWriter fileWriter, LatexDivision latexDivision) {
        this.fileWriter = fileWriter;
        this.latexDivision = latexDivision;
    }

    @Override
    public void write(Integer level, String title) {
        logger.debug("LatexDivisionHeaderImpl::write");
        fileWriter.writeLine(latexDivision.header(level)
                + title + LatexConstants.TERM_END);
    }

    @Override
    public void write(String levelString, String title) {
        Integer level = Integer.valueOf(levelString);
        write(level, title);
    }
}
