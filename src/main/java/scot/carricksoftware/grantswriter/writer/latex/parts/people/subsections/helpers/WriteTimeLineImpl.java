/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTabLeEnd;
import scot.carricksoftware.grantswriter.writer.latex.LatexLongTableStart;

import java.util.List;
import java.util.TreeMap;


@Component
public class WriteTimeLineImpl implements WriteTimeLine {

    private static final Logger logger = LogManager.getLogger(WriteTimeLineImpl.class);

    private final FileWriter fileWriter;
    private final LatexLongTableStart latexLongTableStart;
    private final LatexLongTabLeEnd latexLongTabLeEnd;

    public WriteTimeLineImpl(FileWriter fileWriter,
                             LatexLongTableStart latexLongTableStart,
                             LatexLongTabLeEnd latexLongTabLeEnd) {
        this.fileWriter = fileWriter;
        this.latexLongTableStart = latexLongTableStart;
        this.latexLongTabLeEnd = latexLongTabLeEnd;
    }

    @Override
    public void write(TreeMap<DMY, List<String>> map) {
        logger.info("PersonSubSectionTimeLineWriterImp::write");

        latexLongTableStart.write("l l");
        writeTheData(map);
        latexLongTabLeEnd.write();
    }

    private void writeTheData(TreeMap<DMY, List<String>> map) {
        logger.info("PersonSubSectionTimeLineWriterImp::writeTheData");

        for (DMY dmy : map.keySet()) {
            var value = map.get(dmy);
            for (String event : value) {
                String builder = dmy.toString() +
                        LatexConstants.TABLE_COLUMN_END +
                        event +
                        LatexConstants.TABLE_LINE_END;
                fileWriter.writeLine(builder);
            }
        }
    }
}
