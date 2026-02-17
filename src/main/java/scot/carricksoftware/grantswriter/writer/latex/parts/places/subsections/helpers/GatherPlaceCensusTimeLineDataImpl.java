/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.census.Census;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.services.census.CensusService;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.census.GatherPlaceCensusWhereTakenTimeLineData;

import java.util.List;

@Component
public class GatherPlaceCensusTimeLineDataImpl implements GatherPlaceCensusTimeLineData {

    private final CensusService censusService;
    private final TimeLineData timelineData;

    final GatherPlaceCensusWhereTakenTimeLineData gatherPlaceCensusWhereTakenTimeLineData;

    public GatherPlaceCensusTimeLineDataImpl(CensusService censusService,
                                             TimeLineData timelineData,
                                             GatherPlaceCensusWhereTakenTimeLineData gatherPlaceCensusWhereTakenTimeLineData) {
        this.censusService = censusService;
        this.timelineData = timelineData;
        this.gatherPlaceCensusWhereTakenTimeLineData = gatherPlaceCensusWhereTakenTimeLineData;
    }

    @Override
    public void gather(Place place) {
        List<Census> censusList = censusService.findAllByPlace(place);
        if (!censusList.isEmpty()) {
            gatherPlaceCensusWhereTakenTimeLineData.gather(censusList);
        }
    }
}
