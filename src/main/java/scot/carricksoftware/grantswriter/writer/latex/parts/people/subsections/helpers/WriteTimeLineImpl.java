/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTabLeEnd;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTableStart;

import java.util.List;


@Component
public class WriteTimeLineImpl implements WriteTimeLine {

    private static final Logger logger = LogManager.getLogger(WriteTimeLineImpl.class);

    private final FileWriter fileWriter;
    private final LatexLongTableStart latexLongTableStart;
    private final LatexLongTabLeEnd latexLongTabLeEnd;
    private final DateSortLinkedMultiValueMap dateSortLinkedMultiValueMap;

    public WriteTimeLineImpl(FileWriter fileWriter,
                             LatexLongTableStart latexLongTableStart,
                             LatexLongTabLeEnd latexLongTabLeEnd, DateSortLinkedMultiValueMap dateSortLinkedMultiValueMap) {
        this.fileWriter = fileWriter;
        this.latexLongTableStart = latexLongTableStart;
        this.latexLongTabLeEnd = latexLongTabLeEnd;
        this.dateSortLinkedMultiValueMap = dateSortLinkedMultiValueMap;
    }

    @Override
    public void write(LinkedMultiValueMap<String, String> map) {
        logger.info("PersonSubSectionTimeLineWriterImp::write");

        latexLongTableStart.write("l l");
        map = dateSortLinkedMultiValueMap.sort(map);
        writeTheData(map);
        latexLongTabLeEnd.write();
    }

    private void writeTheData(LinkedMultiValueMap<String, String> map) {
        logger.info("PersonSubSectionTimeLineWriterImp::writeTHeData");

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
