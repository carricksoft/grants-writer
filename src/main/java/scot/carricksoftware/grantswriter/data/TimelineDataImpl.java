/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;

import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

@Component
public class TimelineDataImpl implements TimelineData {

    private SortedMap<String, String> timeline;

    private SortedSet<String> refs;

    public TimelineDataImpl() {
        this.timeline = new TreeMap<>();
        this.refs = new TreeSet<>();
    }

    @Override
    public void clear() {
        timeline.clear();
        refs.clear();
    }

    @Override
    public void add(List<CensusEntry> censusEntryList) {
        for (CensusEntry censusEntry : censusEntryList) {
            timeline.put(censusEntry.getCensus().getCensusDate().label,
                    "Recorded as being at " +
                            censusEntry.getCensus().getPlace().toString());
            if (censusEntry.getPersonalOccupation() != null && !censusEntry.getPersonalOccupation().isEmpty()) {
                timeline.put(censusEntry.getCensus().getCensusDate().label,
                        "Occupation recorded as " +
                                censusEntry.getPersonalOccupation());
            }
            refs.add(censusEntry.getCensus().toString());
        }

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
