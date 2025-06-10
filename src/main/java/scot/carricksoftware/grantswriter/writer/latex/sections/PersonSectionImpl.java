/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.sections;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.PersonSectionHeader;
import scot.carricksoftware.grantswriter.domains.people.Person;

@Component
public class PersonSectionImpl implements PersonSection {

    private final PersonSectionHeader personSectionHeader;
    private final PersonSubSectionTimeLineWriter personSubSectionTimeLineWriter;
    private final PersonSubSectionReferencesWriter personSubSectionReferencesWriter;

    public PersonSectionImpl(PersonSectionHeader personSectionHeader,
                             PersonSubSectionTimeLineWriter personSubSectionTimeLineWriter,
                             PersonSubSectionReferencesWriter personSubSectionReferencesWriter) {
        this.personSectionHeader = personSectionHeader;
        this.personSubSectionTimeLineWriter = personSubSectionTimeLineWriter;
        this.personSubSectionReferencesWriter = personSubSectionReferencesWriter;
    }

    @Override
    public void write(Person person) {
        personSectionHeader.write(person);
        personSubSectionTimeLineWriter.write(person);
        personSubSectionReferencesWriter.write(person);
    }
}
