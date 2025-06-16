/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.censusentry.CensusEntryService;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.WriteTimeLine;

import java.util.List;

@Component
public class PersonSubSectionTimeLineWriterImpl implements PersonSubSectionTimeLineWriter {

    private static final Logger logger = LogManager.getLogger(PersonSubSectionTimeLineWriterImpl.class);

    private final LatexSubSectionHeader latexSubSectionHeader;
    private final CensusEntryService censusEntryService;
    private final TimeLineData timelineData;
    private final WriteTimeLine writeTimeLine;

    public PersonSubSectionTimeLineWriterImpl(LatexSubSectionHeader latexSubSectionHeader,
                                              CensusEntryService censusEntryService,
                                              TimeLineData timelineData,
                                              WriteTimeLine writeTimeLine) {
        this.latexSubSectionHeader = latexSubSectionHeader;
        this.censusEntryService = censusEntryService;
        this.timelineData = timelineData;
        this.writeTimeLine = writeTimeLine;
    }

    @Override
    public void write(Person person) {
        logger.info("PersonSubSectionTimeLineWriterImp::write");

        latexSubSectionHeader.write("Timeline");
        List<CensusEntry> censusEntryList = censusEntryService.findAllByPerson(person);
        timelineData.clear();
        timelineData.add(censusEntryList);

        writeTimeLine.write(timelineData.getTimeLine());
    }


}
