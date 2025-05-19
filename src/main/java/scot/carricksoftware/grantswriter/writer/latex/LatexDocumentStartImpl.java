/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.writer.FileWriter;

@Component
public class LatexDocumentStartImpl implements LatexDocumentStart {

    private final FileWriter fileWriter;

    public LatexDocumentStartImpl(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void write() {
        fileWriter.writeLine(LatexConstants.DOCUMENT_START);
    }
}
