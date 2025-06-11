/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.springframework.util.LinkedMultiValueMap;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;

import java.util.List;
import java.util.SortedSet;

public interface TimelineData {

    @SuppressWarnings("unused")
    void clear();
    @SuppressWarnings({"EmptyMethod", "unused"})

    void add(List<CensusEntry> censusEntryList);

    @SuppressWarnings("unused")
    LinkedMultiValueMap<String, String> getTimeline();

    @SuppressWarnings("unused")
    void setTimeline(LinkedMultiValueMap<String, String> timeline);

    @SuppressWarnings("unused")
    SortedSet<String> getRefs();

    @SuppressWarnings("unused")
    void setRefs(SortedSet<String> refs);
}
