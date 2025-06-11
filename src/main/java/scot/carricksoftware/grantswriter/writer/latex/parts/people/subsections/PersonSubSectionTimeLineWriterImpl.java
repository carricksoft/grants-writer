/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.TimelineData;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.censusentry.CensusEntryService;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;

import java.util.List;

@Component
public class PersonSubSectionTimeLineWriterImpl implements PersonSubSectionTimeLineWriter {

    private final LatexSubSectionHeader latexSubSectionHeader;
    private final CensusEntryService censusEntryService;
    private final TimelineData timelineData;

    public PersonSubSectionTimeLineWriterImpl(LatexSubSectionHeader latexSubSectionHeader, CensusEntryService censusEntryService, TimelineData timelineData) {
        this.latexSubSectionHeader = latexSubSectionHeader;
        this.censusEntryService = censusEntryService;
        this.timelineData = timelineData;
    }

    @Override
    public void write(Person person) {
        // get census record for name
        latexSubSectionHeader.write("Timeline");
        List<CensusEntry>  censusEntryList = censusEntryService.findAllByPerson(person);
        timelineData.add(censusEntryList);
    }
}
