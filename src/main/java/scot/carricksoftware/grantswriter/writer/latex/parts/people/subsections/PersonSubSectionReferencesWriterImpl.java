/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;

@Component
public class PersonSubSectionReferencesWriterImpl implements PersonSubSectionReferencesWriter {

    private final LatexSubSectionHeader latexSubSectionHeader;

    public PersonSubSectionReferencesWriterImpl(LatexSubSectionHeader latexSubSectionHeader) {
        this.latexSubSectionHeader = latexSubSectionHeader;
    }

    @Override
    public void write(Person person) {
        latexSubSectionHeader.write("References");
    }

}
