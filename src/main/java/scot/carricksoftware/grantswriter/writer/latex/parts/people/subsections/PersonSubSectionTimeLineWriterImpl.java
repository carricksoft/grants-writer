/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.data.TimelineData;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.censusentry.CensusEntryService;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTabLeEnd;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTableStart;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;

import java.util.List;

@Component
public class PersonSubSectionTimeLineWriterImpl implements PersonSubSectionTimeLineWriter {

    private static final Logger logger = LogManager.getLogger(PersonSubSectionTimeLineWriterImpl.class);

    private final LatexSubSectionHeader latexSubSectionHeader;
    private final CensusEntryService censusEntryService;
    private final TimelineData timelineData;
    private final FileWriter fileWriter;
    private final LatexLongTableStart latexLongTableStart;
    private final LatexLongTabLeEnd latexLongTabLeEnd;

    public PersonSubSectionTimeLineWriterImpl(LatexSubSectionHeader latexSubSectionHeader,
                                              CensusEntryService censusEntryService,
                                              TimelineData timelineData,
                                              FileWriter fileWriter, LatexLongTableStart latexLongTableStart, LatexLongTabLeEnd latexLongTabLeEnd) {
        this.latexSubSectionHeader = latexSubSectionHeader;
        this.censusEntryService = censusEntryService;
        this.timelineData = timelineData;
        this.fileWriter = fileWriter;
        this.latexLongTableStart = latexLongTableStart;
        this.latexLongTabLeEnd = latexLongTabLeEnd;
    }

    @Override
    public void write(Person person) {
        logger.info("PersonSubSectionTimeLineWriterImp::write");
        latexSubSectionHeader.write("Timeline");
        List<CensusEntry>  censusEntryList = censusEntryService.findAllByPerson(person);
        timelineData.clear();
        timelineData.add(censusEntryList);
        latexLongTableStart.write("l l");
        writeData(timelineData.getTimeline());
        latexLongTabLeEnd.write();
    }

    private void writeData(LinkedMultiValueMap<String, String> map) {
        logger.info("PersonSubSectionTimeLineWriterImp::writeData");

        for (String key : map.keySet()) {
            List<String> value = map.get(key);
            if (value != null) {
                for (String v : value) {
                    String builder = key +
                            LatexConstants.TABLE_COLUMN_END +
                            v +
                            LatexConstants.TABLE_LINE_END;
                    fileWriter.writeLine(builder);
                }
            }
        }




    }
}
