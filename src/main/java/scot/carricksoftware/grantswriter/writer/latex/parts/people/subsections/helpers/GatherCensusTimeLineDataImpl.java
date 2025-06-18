/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.censusentry.CensusEntryService;

import java.util.List;

@Component
public class GatherCensusTimeLineDataImpl implements GatherCensusTimeLineData {

    private final CensusEntryService censusEntryService;
    private final TimeLineData timelineData;

    public GatherCensusTimeLineDataImpl(
            CensusEntryService censusEntryService,
            TimeLineData timelineData) {
        this.censusEntryService = censusEntryService;
        this.timelineData = timelineData;
    }

    @Override
    public void gather(Person person) {
        List<CensusEntry> censusEntryList = censusEntryService.findAllByPerson(person);
        timelineData.add(censusEntryList);
    }
}
