/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.text.BaseText;
import scot.carricksoftware.grantswriter.writer.FileWriter;

@Component
public class WriteBaseTextImpl implements WriteBaseText {

    private final LatexDivisionHeader latexDivisionHeader;

    private final FileWriter fileWriter;

    public WriteBaseTextImpl(FileWriter fileWriter, LatexDivisionHeader latexDivisionHeader) {
        this.fileWriter = fileWriter;
        this.latexDivisionHeader = latexDivisionHeader;
    }

    @Override
    public void write(BaseText baseText) {
        latexDivisionHeader.write(baseText.getLevel(), baseText.getHeading());
        fileWriter.writeLine(baseText.getContent());
    }
}
