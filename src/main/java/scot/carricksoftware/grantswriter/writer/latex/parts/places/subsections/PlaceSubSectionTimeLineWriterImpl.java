/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.WriteTimeLine;

@Component
public class PlaceSubSectionTimeLineWriterImpl implements PlaceSubSectionTimeLineWriter {

    private static final Logger logger = LogManager.getLogger(PlaceSubSectionTimeLineWriterImpl.class);

    private final LatexSubSectionHeader latexSubSectionHeader;
    private final WriteTimeLine writeTimeLine;

    public PlaceSubSectionTimeLineWriterImpl(
            LatexSubSectionHeader latexSubSectionHeader,
            WriteTimeLine writeTimeLine) {
        this.latexSubSectionHeader = latexSubSectionHeader;
        this.writeTimeLine = writeTimeLine;
    }

    @Override
    public void write() {
        logger.info("PlaceSubSectionTimeLineWriterImp::write");
        latexSubSectionHeader.write("Timeline");
        writeTimeLine.write();
    }


}
