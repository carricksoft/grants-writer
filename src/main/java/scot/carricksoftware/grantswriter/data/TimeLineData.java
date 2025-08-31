/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import scot.carricksoftware.grantswriter.domains.census.CensusEntry;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;

public interface TimeLineData {

    void addCensusEntry(List<CensusEntry> censusEntryList);

    void clear();

    TreeMap<DMY, List<String>> getTimeLine();

    void setTimeline(TreeMap<DMY, List<String>> timeLine);

    SortedSet<String> getRefs();

    void setRefs(SortedSet<String> refs);
}
