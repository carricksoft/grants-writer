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
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.ClearExistingTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.GatherTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.WriteReferences;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.WriteTimeLine;

@Component
public class PersonSubSectionTimeLineWriterImpl implements PersonSubSectionTimeLineWriter {

    private static final Logger logger = LogManager.getLogger(PersonSubSectionTimeLineWriterImpl.class);

    private final LatexSubSectionHeader latexSubSectionHeader;
    private final WriteTimeLine writeTimeLine;
    private final WriteReferences writeReferences;
    private final ClearExistingTimeLineData clearExistingTimeLineData;
    private final GatherTimeLineData gatherTimeLineData;

    public PersonSubSectionTimeLineWriterImpl(LatexSubSectionHeader latexSubSectionHeader,
                                              WriteTimeLine writeTimeLine,
                                              WriteReferences writeReferences,
                                              ClearExistingTimeLineData clearExistingTimeLineData,
                                              GatherTimeLineData gatherTimeLineData) {

        this.latexSubSectionHeader = latexSubSectionHeader;
        this.writeTimeLine = writeTimeLine;
        this.writeReferences = writeReferences;
        this.clearExistingTimeLineData = clearExistingTimeLineData;
        this.gatherTimeLineData = gatherTimeLineData;
    }

    @Override
    public void write(Person person) {
        logger.info("PersonSubSectionTimeLineWriterImp::write");

        latexSubSectionHeader.write("Timeline");
        clearExistingTimeLineData.clear();
        gatherTimeLineData.gather();

        writeTimeLine.write();
        writeReferences.write();
    }


}
