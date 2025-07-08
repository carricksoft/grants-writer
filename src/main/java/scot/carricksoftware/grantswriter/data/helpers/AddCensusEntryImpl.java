/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.DMYImpl;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;

@Component
public class AddCensusEntryImpl implements AddCensusEntry {
    private static final Logger logger = LogManager.getLogger(AddCensusEntryImpl.class);

    @Override
    public void add(TreeMap<DMY, List<String>> timeLine, SortedSet<String> refs, List<CensusEntry> censusEntryList) {
        logger.info("AddCensusEntry::addCensusEntry");
        for (CensusEntry censusEntry : censusEntryList) {
            String key = censusEntry.getCensus().getCensusDate().label;
            DMY dmyKey = new DMYImpl();
            dmyKey.parse(key);

            List<String> existingValues = timeLine.get(dmyKey);
            if (existingValues == null) {
                existingValues = new ArrayList<>();
            }
            existingValues.add("Recorded as being at " +
                    censusEntry.getCensus().getPlace().toString());
            timeLine.put(dmyKey, existingValues);

            if (censusEntry.getPersonalOccupation() != null && !censusEntry.getPersonalOccupation().isEmpty()) {
                existingValues.add("Occupation recorded as " +
                        censusEntry.getPersonalOccupation());
                timeLine.put(dmyKey, existingValues);
            }
            refs.add("Census: " + censusEntry.getCensus().toString());
        }
    }
}
