/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.census;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.DMYImpl;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.census.Census;
import scot.carricksoftware.grantswriter.services.census.CensusService;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Component
public class GatherPlaceCensusWhereTakenTimeLineDataImpl implements GatherPlaceCensusWhereTakenTimeLineData {

    private static final Logger logger = LogManager.getLogger(GatherPlaceCensusWhereTakenTimeLineDataImpl.class);

    private final TimeLineData timelineData;
    private final CensusService censusService;

    public GatherPlaceCensusWhereTakenTimeLineDataImpl(TimeLineData timelineData, CensusService censusService) {
        this.timelineData = timelineData;
        this.censusService = censusService;
    }

    @Override
    public void gather(List<Census> censuses) {
        logger.info("GatherBirthCertificateNewBornTimeLineDataImpl::Gather");
        for (Census census : censuses) {
            addWhereTaken(timelineData.getTimeLine(), census);
            addRefs(census);
        }
    }

    private void addWhereTaken(TreeMap<DMY, List<String>> timeLine, Census census) {
        logger.info("GatherPlaceCensusTimeLineDataImpl::AddWhereTaken");

        List<String> existingValues = timeLine.get(getDMY(census.getCensusDate().label));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        existingValues.add(census.getCensusDate().label + " Census Taken here.");
        timeLine.put(getDMY(census.getCensusDate().label), existingValues);

    }

    private void addRefs(Census census) {
        timelineData.getRefs().add("Census : " + census.getPlace().toString() + " at " + census.getCensusDate().label);
    }



    private DMY getDMY(String dateKey) {
        DMY dmyKey = new DMYImpl();
        dmyKey.parse(dateKey);
        return dmyKey;
    }
}
