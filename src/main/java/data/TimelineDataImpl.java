/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package data;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.CensusEntry;

import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;

@Component
public class TimelineDataImpl implements TimelineData {

    private SortedMap<String, String> timeline;

    private SortedSet<String> refs;

    @Override
    public void clear() {
        timeline.clear();
        refs.clear();
    }

    @Override
    public void add(List<CensusEntry> censusEntryList) {

    }

    @Override
    public SortedMap<String, String> getTimeline() {
        return timeline;
    }

    @Override
    public void setTimeline(SortedMap<String, String> timeline) {
        this.timeline = timeline;
    }

    @Override
    public SortedSet<String> getRefs() {
        return refs;
    }

    @Override
    public void setRefs(SortedSet<String> refs) {
        this.refs = refs;
    }
}
