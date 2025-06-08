/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.sections;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.PersonSectionHeader;

@Component
public class PersonSectionImpl implements PersonSection {

    private final PersonSectionHeader personSectionHeader;

    public PersonSectionImpl(PersonSectionHeader personSectionHeader) {
        this.personSectionHeader = personSectionHeader;
    }

    @Override
    public void write(Person person) {
        personSectionHeader.write(person);
    }
}
