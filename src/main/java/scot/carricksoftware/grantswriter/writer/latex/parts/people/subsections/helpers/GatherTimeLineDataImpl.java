/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;

@Component
public class GatherTimeLineDataImpl implements GatherTimeLineData {

   private final GatherCensusTimeLineData gatherCensusTimeLineData;

    public GatherTimeLineDataImpl(
            GatherCensusTimeLineData gatherCensusTimeLineData) {
        this.gatherCensusTimeLineData = gatherCensusTimeLineData;
    }

    @Override
    public void gather(Person person) {
        gatherCensusTimeLineData.gather(person);
    }
}
