/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.converters.StringToFileConverter;
import scot.carricksoftware.grantswriter.domains.images.BaseImage;
import scot.carricksoftware.grantswriter.domains.images.Image;
import scot.carricksoftware.grantswriter.writer.FileWriter;

@Component
public class WriteBaseImageImpl implements WriteBaseImage {


    @SuppressWarnings({"unused"})
    private final FileWriter fileWriter;
    private final LatexBlock latexBlock;
    private final StringToFileConverter stringToFileConverter;

    public WriteBaseImageImpl(FileWriter fileWriter, LatexDivisionHeader latexDivisionHeader, LatexBlock latexBlock, StringToFileConverter stringToFileConverter) {
        this.fileWriter = fileWriter;
        this.latexBlock = latexBlock;
        this.stringToFileConverter = stringToFileConverter;
    }

    @Override
    public void write(BaseImage baseImage) {
        createActualImage(baseImage.getImage());
        latexBlock.begin("center", "");
        //noinspection SpellCheckingInspection
        fileWriter.writeLine("\\includegraphics[width=0.25\\linewidth]" +
                LatexConstants.TERM_START +
                ApplicationConstants.TEMP_DIRECTORY  +
                baseImage.getImage().getFileName() +
                LatexConstants.TERM_END);
        latexBlock.end("center");
    }

    private void createActualImage(Image image) {
        String fileName = ApplicationConstants.TEMP_DIRECTORY + image.getFileName();
        stringToFileConverter.convert(image.getImageData(), fileName);
    }
}
