/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.headers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.converters.StringToFileConverter;
import scot.carricksoftware.grantswriter.domains.images.Image;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexBlock;
import scot.carricksoftware.grantswriter.writer.latex.LatexSectionHeader;
import scot.carricksoftware.grantswriter.domains.people.Person;

@Component
public class PersonSectionHeaderImpl implements PersonSectionHeader {

    private final LatexSectionHeader latexSectionHeader;
    private final FileWriter fileWriter;
    private final LatexBlock latexBlock;
    private final StringToFileConverter stringToFileConverter;

    public PersonSectionHeaderImpl(LatexSectionHeader latexSectionHeader,
                                   FileWriter fileWriter,
                                   LatexBlock latexBlock, StringToFileConverter stringToFileConverter) {
        this.latexSectionHeader = latexSectionHeader;
        this.fileWriter = fileWriter;
        this.latexBlock = latexBlock;
        this.stringToFileConverter = stringToFileConverter;
    }

    @Override
    public void write(Person person) {
        latexSectionHeader.write(person.toString());
        if (person.getImage() != null) {
            writePersonImage(person.getImage());
        }
    }

    private void writePersonImage(final Image image) {
        createActualImage(image);
        latexBlock.begin("center", "");
        //noinspection SpellCheckingInspection
        fileWriter.writeLine("\\includegraphics[width=0.25\\linewidth]" +
                LatexConstants.TERM_START +
                ApplicationConstants.TEMP_DIRECTORY  +
                image.getFileName() +
                LatexConstants.TERM_END);
        latexBlock.end("center");
    }

    private void createActualImage(Image image) {
        String fileName = ApplicationConstants.TEMP_DIRECTORY + image.getFileName();
        stringToFileConverter.convert(image.getImageData(), fileName);
    }
}
