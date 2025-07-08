/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

@Component
public class TimeLineDataImpl implements TimeLineData {

    private TreeMap<DMY, List<String>> timeLine;

    private SortedSet<String> refs;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final TimeLineDateComparator timeLineDateComparator;

    public TimeLineDataImpl( TimeLineDateComparator timeLineDateComparator) {
        this.timeLineDateComparator = timeLineDateComparator;
        this.timeLine = new TreeMap<>();
        this.refs = new TreeSet<>();
    }


    @Override
    public void addCensusEntry(List<CensusEntry> censusEntryList) {
        for (CensusEntry censusEntry : censusEntryList) {
            String key = censusEntry.getCensus().getCensusDate().label;
            DMY dmyKey = new DMYImpl();
            dmyKey.parse(key);

            List<String> existingValues = timeLine.get(dmyKey);
            if (existingValues == null) {
                existingValues = new ArrayList<>();
            }
            existingValues.add( "Recorded as being at " +
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

    @Override
    public void clear() {
        timeLine.clear();
        refs.clear();
    }

    @Override
    public TreeMap<DMY, List<String>> getTimeLine() {
        return timeLine;
    }

    @Override
    public void setTimeline(TreeMap<DMY, List<String>> timeLine) {
        this.timeLine = timeLine;
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
