/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import scot.carricksoftware.grantswriter.domains.CensusEntry;

import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;

public interface TimelineData {

    @SuppressWarnings("unused")
    void clear();
    @SuppressWarnings({"EmptyMethod", "unused"})
    void add(@SuppressWarnings("unused") List<CensusEntry> censusEntryList);

    @SuppressWarnings("unused")
    SortedMap<String, String> getTimeline();

    @SuppressWarnings("unused")
    void setTimeline(SortedMap<String, String> timeline);

    @SuppressWarnings("unused")
    SortedSet<String> getRefs();

    @SuppressWarnings("unused")
    void setRefs(SortedSet<String> refs);
}
