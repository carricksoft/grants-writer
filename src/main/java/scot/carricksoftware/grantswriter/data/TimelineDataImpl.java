/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Component
public class TimelineDataImpl implements TimelineData {

    private LinkedMultiValueMap<String, String> timeline;

    private SortedSet<String> refs;

    public TimelineDataImpl() {
        this.timeline = new LinkedMultiValueMap<>();
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
            timeline.add(censusEntry.getCensus().getCensusDate().label,
                    "Recorded as being at " +
                            censusEntry.getCensus().getPlace().toString());
            if (censusEntry.getPersonalOccupation() != null && !censusEntry.getPersonalOccupation().isEmpty()) {
                timeline.add(censusEntry.getCensus().getCensusDate().label,
                        "Occupation recorded as " +
                                censusEntry.getPersonalOccupation());
            }
            refs.add(censusEntry.getCensus().toString());
        }
    }

    @Override
    public LinkedMultiValueMap<String, String> getTimeline() {
        return timeline;
    }

    @Override
    public void setTimeline(LinkedMultiValueMap<String, String> timeline) {
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
