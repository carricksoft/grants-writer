/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;

@Component
public class PersonSubSectionTimeLineWriterImpl implements PersonSubSectionTimeLineWriter {

private final LatexSubSectionHeader latexSubSectionHeader;

    public PersonSubSectionTimeLineWriterImpl(LatexSubSectionHeader latexSubSectionHeader) {
        this.latexSubSectionHeader = latexSubSectionHeader;
    }

    @Override
    public void write(Person person) {
        // get census record for name
        latexSubSectionHeader.write("Timeline");
    }
}
