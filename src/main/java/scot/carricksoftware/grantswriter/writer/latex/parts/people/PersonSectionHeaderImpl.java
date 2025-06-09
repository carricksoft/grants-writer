/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.LatexSectionHeader;
import scot.carricksoftware.grantswriter.domains.people.Person;

@Component
public class PersonSectionHeaderImpl implements PersonSectionHeader {

    private final LatexSectionHeader latexSectionHeader;

    public PersonSectionHeaderImpl(LatexSectionHeader latexSectionHeader) {
        this.latexSectionHeader = latexSectionHeader;
    }

    @Override
    public void write(Person person) {
        latexSectionHeader.write(person.toString());
    }
}
