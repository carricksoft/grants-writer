/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.LatexDocumentEnd;
import scot.carricksoftware.grantswriter.writer.latex.LatexDocumentStart;

@Component
public class TexWriterImpl implements TexWriter {

    private final FileWriter fileWriter;

    private final LatexDocumentStart docStart;
    private final LatexDocumentEnd docEnd;

    public TexWriterImpl(FileWriter fileWriter, LatexDocumentStart docStart, LatexDocumentEnd docEnd) {
        this.fileWriter = fileWriter;
        this.docStart = docStart;
        this.docEnd = docEnd;
    }

    @Override
    public void write(String filename) throws Exception {
        fileWriter.init(filename);
        docStart.write();
        docEnd.write();
        fileWriter.close();
    }
}
