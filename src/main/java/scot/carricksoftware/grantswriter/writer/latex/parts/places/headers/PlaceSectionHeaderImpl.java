/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.headers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.converters.StringToFileConverter;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexBlock;
import scot.carricksoftware.grantswriter.writer.latex.LatexSectionHeader;

@Component
public class PlaceSectionHeaderImpl implements PlaceSectionHeader {

    private final LatexSectionHeader latexSectionHeader;
    private final FileWriter fileWriter;
    private final LatexBlock latexBlock;
    private final StringToFileConverter stringToFileConverter;

    public PlaceSectionHeaderImpl(LatexSectionHeader latexSectionHeader,
                                  FileWriter fileWriter,
                                  LatexBlock latexBlock,
                                  StringToFileConverter stringToFileConverter) {
        this.latexSectionHeader = latexSectionHeader;
        this.fileWriter = fileWriter;
        this.latexBlock = latexBlock;
        this.stringToFileConverter = stringToFileConverter;
    }

    @Override
    public void write(Place place) {
        latexSectionHeader.write(place.toString());

//        if (place.getImage() != null) {
//            writePersonImage(place.getImage());
//        }
    }
//
//    private void writePlaceImage(final Image image) {
//        createActualImage(image);
//        latexBlock.begin("center", "");
//        fileWriter.writeLine("\\includegraphics[width=0.25\\linewidth]" +
//                LatexConstants.TERM_START +
//                ApplicationConstants.TEMP_DIRECTORY  +
//                image.getFileName() +
//                LatexConstants.TERM_END);
//        latexBlock.end("center");
//    }
//
//    private void createActualImage(Image image) {
//        String fileName = ApplicationConstants.TEMP_DIRECTORY + image.getFileName();
//        stringToFileConverter.convert(image.getImageData(), fileName);
//    }
}
