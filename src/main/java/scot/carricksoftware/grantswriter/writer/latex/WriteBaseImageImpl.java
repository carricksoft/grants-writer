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


    public WriteBaseImageImpl(FileWriter fileWriter,
                              LatexBlock latexBlock,
                              StringToFileConverter stringToFileConverter) {
        this.fileWriter = fileWriter;
        this.latexBlock = latexBlock;
        this.stringToFileConverter = stringToFileConverter;
    }

    @Override
    public void write(BaseImage baseImage) {
        createActualImage(baseImage.getImage());
        latexBlock.begin("figure", "");
        latexBlock.begin("center", "");
        writeImage(baseImage);
        writeCaption(baseImage.getCaption());
        latexBlock.end("center");
        latexBlock.end("figure");
    }

    private void writeCaption(String caption) {
        if (caption != null  && !caption.isEmpty()) {
            fileWriter.writeLine("\\caption{" + caption + "}");
        }
    }

    private void writeImage(BaseImage baseImage) {
        double scaleFactor = 0.25 / 100;
        double scaleHeight = Double.parseDouble(baseImage.getHeight()) * scaleFactor;
        double scaleWidth = Double.parseDouble(baseImage.getWidth()) * scaleFactor;
        fileWriter.writeLine("\\includegraphics[" +
                "max width=" +
                String.format("%.2f", scaleWidth) +
                "\\linewidth" +
                "," +
                "max height=" +
                String.format("%.2f", scaleHeight) +
                "\\linewidth" +
                "]" +
                LatexConstants.TERM_START +
                ApplicationConstants.TEMP_DIRECTORY  +
                baseImage.getImage().getFileName() +
                LatexConstants.TERM_END);
    }

    private void createActualImage(Image image) {
        String fileName = ApplicationConstants.TEMP_DIRECTORY + image.getFileName();
        stringToFileConverter.convert(image.getImageData(), fileName);
    }


}
