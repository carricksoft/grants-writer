/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.LatexDocumentEnd;
import scot.carricksoftware.grantswriter.writer.latex.LatexDocumentStart;
import scot.carricksoftware.grantswriter.writer.latex.parts.PartsWriter;

@Component
public class TexWriterImpl implements TexWriter {

    private static final Logger logger = LogManager.getLogger(TexWriterImpl.class);

    private final FileWriter fileWriter;

    private final LatexDocumentStart docStart;
    private final LatexDocumentEnd docEnd;
    private final PartsWriter partsWriter;


    public TexWriterImpl(FileWriter fileWriter, LatexDocumentStart docStart, LatexDocumentEnd docEnd, PartsWriter partsWriter) {
        this.fileWriter = fileWriter;
        this.docStart = docStart;
        this.docEnd = docEnd;
        this.partsWriter = partsWriter;
    }

    @Override
    public void write(String filename) throws Exception {
        logger.info("TexWriter::write");
        fileWriter.init(filename);
        docStart.write();
        partsWriter.write();
        docEnd.write();
        fileWriter.close();
    }
}
