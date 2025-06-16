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

    private TreeMap<DMY, List<String>> timeline;

    private SortedSet<String> refs;

    private final DMY dmy;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final TimeLineDateComparator timeLineDateComparator;

    public TimeLineDataImpl(DMY dmy, TimeLineDateComparator timeLineDateComparator) {
        this.dmy = dmy;
        this.timeLineDateComparator = timeLineDateComparator;
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
            String key = censusEntry.getCensus().getCensusDate().label;
            dmy.parse(key);

            List<String> values = timeline.get(dmy);
            if (values == null) {
                values = new ArrayList<>();
            }
            values.add( "Recorded as being at " +
                    censusEntry.getCensus().getPlace().toString());
            timeline.put(dmy, values);

            if (censusEntry.getPersonalOccupation() != null && !censusEntry.getPersonalOccupation().isEmpty()) {
                values.add("Occupation recorded as " +
                                censusEntry.getPersonalOccupation());
                timeline.put(dmy, values);
            }
            refs.add(censusEntry.getCensus().toString());
        }
    }

    @Override
    public TreeMap<DMY, List<String>> getTimeline() {
        return timeline;
    }

    @Override
    public void setTimeline(TreeMap<DMY, List<String>> timeline) {
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
