/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data.helpers;

import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;

public interface AddCensusEntry {

    void add(TreeMap<DMY, List<String>> timeLine, SortedSet<String> refs, List<CensusEntry> censusEntryList);
}
