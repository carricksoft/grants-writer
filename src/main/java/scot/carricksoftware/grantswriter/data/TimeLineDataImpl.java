/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.helpers.AddCensusEntry;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

@Component
public class TimeLineDataImpl implements TimeLineData {

    private static final Logger logger = LogManager.getLogger(TimeLineDataImpl.class);

    private TreeMap<DMY, List<String>> timeLine;

    private SortedSet<String> refs;

    private final AddCensusEntry addCensusEntry;

    public TimeLineDataImpl(AddCensusEntry addCensusEntry) {
        this.addCensusEntry = addCensusEntry;
        this.timeLine = new TreeMap<>();
        this.refs = new TreeSet<>();
    }

    @Override
    public void addCensusEntry(List<CensusEntry> censusEntryList) {
        logger.info("TimeLineDataImpl::addCensusEntry");
        addCensusEntry.add(timeLine, refs, censusEntryList);
    }

    @Override
    public void clear() {
        logger.info("TimeLineDataImpl::clear");
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
