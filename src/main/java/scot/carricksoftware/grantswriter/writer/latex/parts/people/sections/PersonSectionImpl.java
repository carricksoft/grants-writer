/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.sections;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.headers.PersonSectionHeader;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.PersonSubSectionReferencesWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.PersonSubSectionTimeLineWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.ClearExistingTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.GatherTimeLineData;

@Component
public class PersonSectionImpl implements PersonSection {

    private final PersonSectionHeader personSectionHeader;
    private final PersonSubSectionTimeLineWriter personSubSectionTimeLineWriter;
    private final PersonSubSectionReferencesWriter personSubSectionReferencesWriter;
    private final ClearExistingTimeLineData clearExistingTimeLineData;
    private final GatherTimeLineData gatherTimeLineData;

    public PersonSectionImpl(PersonSectionHeader personSectionHeader,
                             PersonSubSectionTimeLineWriter personSubSectionTimeLineWriter,
                             PersonSubSectionReferencesWriter personSubSectionReferencesWriter,
                             ClearExistingTimeLineData clearExistingTimeLineData,
                             GatherTimeLineData gatherTimeLineData) {
        this.personSectionHeader = personSectionHeader;
        this.personSubSectionTimeLineWriter = personSubSectionTimeLineWriter;
        this.personSubSectionReferencesWriter = personSubSectionReferencesWriter;
        this.clearExistingTimeLineData = clearExistingTimeLineData;
        this.gatherTimeLineData = gatherTimeLineData;
    }

    @Override
    public void write(Person person) {
        personSectionHeader.write(person);
        clearExistingTimeLineData.clear();
        gatherTimeLineData.gather(person);
        personSubSectionTimeLineWriter.write();
        personSubSectionReferencesWriter.write();
    }
}
