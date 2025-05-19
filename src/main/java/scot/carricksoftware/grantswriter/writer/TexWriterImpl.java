/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.LatexDocumentStart;

@Component
public class TexWriterImpl implements TexWriter {

    private final FileWriter fileWriter;

    private final LatexDocumentStart docStart;

    public TexWriterImpl(FileWriter fileWriter, LatexDocumentStart docStart) {
        this.fileWriter = fileWriter;
        this.docStart = docStart;
    }

    @Override
    public void write(String filename) throws Exception {
        fileWriter.init(filename);
        docStart.write();
        fileWriter.close();
    }
}
