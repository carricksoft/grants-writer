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

    @SuppressWarnings("unused")
    void clear();
    @SuppressWarnings({"EmptyMethod", "unused"})

    void add(List<CensusEntry> censusEntryList);

    @SuppressWarnings("unused")
    TreeMap<DMY, List<String>> getTimeline();

    @SuppressWarnings("unused")
    void setTimeline(TreeMap<DMY, List<String>> timeline);

    @SuppressWarnings("unused")
    SortedSet<String> getRefs();

    @SuppressWarnings("unused")
    void setRefs(SortedSet<String> refs);
}
