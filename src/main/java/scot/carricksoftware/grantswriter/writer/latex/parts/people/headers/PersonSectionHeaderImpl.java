/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.headers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
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

    public PersonSectionHeaderImpl(LatexSectionHeader latexSectionHeader,
                                   FileWriter fileWriter,
                                   LatexBlock latexBlock) {
        this.latexSectionHeader = latexSectionHeader;
        this.fileWriter = fileWriter;
        this.latexBlock = latexBlock;
    }

    @Override
    public void write(Person person) {
        latexSectionHeader.write(person.toString());
        if (person.getImage() != null) {
            writePersonImage(person.getImage());
        }
    }

    @SuppressWarnings("unused")
    private void writePersonImage(final Image image) {
        latexBlock.begin("center", "");
        //noinspection SpellCheckingInspection
        fileWriter.writeLine("\\includegraphics[width=0.25\\linewidth]" +
                LatexConstants.TERM_START +
                ApplicationConstants.TEMP_DIRECTORY  +
                "dad.jpg"  +
                LatexConstants.TERM_END);
        latexBlock.end("center");
    }
}
