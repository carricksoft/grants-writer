/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.WriteTimeLine;

@Component
public class PersonSubSectionTimeLineWriterImpl implements PersonSubSectionTimeLineWriter {

    private static final Logger logger = LogManager.getLogger(PersonSubSectionTimeLineWriterImpl.class);

    private final LatexSubSectionHeader latexSubSectionHeader;
    private final WriteTimeLine writeTimeLine;

    public PersonSubSectionTimeLineWriterImpl(
            LatexSubSectionHeader latexSubSectionHeader,
            WriteTimeLine writeTimeLine) {
        this.latexSubSectionHeader = latexSubSectionHeader;
        this.writeTimeLine = writeTimeLine;
    }

    @Override
    public void write(Person person) {
        logger.info("PersonSubSectionTimeLineWriterImp::write");

        latexSubSectionHeader.write("Timeline");
        writeTimeLine.write();
    }


}
