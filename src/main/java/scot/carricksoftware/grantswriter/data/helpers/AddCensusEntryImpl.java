/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;

@Component
public class AddCensusEntryImpl implements AddCensusEntry {

    private static final Logger logger = LogManager.getLogger(AddCensusEntryImpl.class);

    @Override
    public void add(TreeMap<DMY, List<String>> timeline, SortedSet<String> refs, List<CensusEntry> censusEntryList) {
        logger.info("AddCensusEntry::addCensusEntry");
    }
}
