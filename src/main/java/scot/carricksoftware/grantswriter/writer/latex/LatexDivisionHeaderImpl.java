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
        logger.debug("LatexDivisionHeaderImpl::write(public)");
        fileWriter.writeLine(latexDivision.header(level) +
                LatexConstants.TERM_START +
                title
                + LatexConstants.TERM_END);
    }


    @SuppressWarnings("unused")
    private void write(Integer level, String title, String asterisk) {
        logger.debug("LatexDivisionHeaderImpl::write(private)");
        fileWriter.writeLine(latexDivision.header(level) +
                asterisk +
                LatexConstants.TERM_START +
                title
                + LatexConstants.TERM_END);
    }

    @Override
    public void write(String levelString, String title) {
        logger.debug("LatexDivisionHeaderImpl::write(string, string))");
        String newLevelString = levelString;
        String asterisk = "";
        int pos = newLevelString.indexOf("*");
        if (pos != -1) {
           newLevelString = newLevelString.substring(0, pos);
           asterisk ="*";
        }
        Integer level = Integer.valueOf(newLevelString);
        write(level, title, asterisk);
    }
}
