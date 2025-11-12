/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.images.BaseImage;
import scot.carricksoftware.grantswriter.writer.FileWriter;

@Component
public class WriteBaseImageImpl implements WriteBaseImage {


    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private final FileWriter fileWriter;

    public WriteBaseImageImpl(FileWriter fileWriter, LatexDivisionHeader latexDivisionHeader) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void write(BaseImage baseImage) {
            System.out.println("boo");
    }
}
