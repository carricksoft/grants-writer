/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.people.PersonService;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.sections.PersonSection;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.headers.PeoplePartHeader;

import java.util.List;

@Component
public class PeoplePartWriterImpl implements PeoplePartWriter {

    private static final Logger logger = LogManager.getLogger(PeoplePartWriterImpl.class);

    private final PersonService personService;
    private final PeoplePartHeader peoplePartHeader;
    private final PersonSection personSection;



    public PeoplePartWriterImpl(PersonService personService,
                                PeoplePartHeader peopleHeader,
                                PersonSection personSection) {
        this.personService = personService;
        this.peoplePartHeader = peopleHeader;
        this.personSection = personSection;
    }

    @Override
    public void write() {
        logger.debug("PeoplePartsImpl::write()");

        peoplePartHeader.write();
        List<Person> people = personService.findAll();
        for (Person person : people) {
            personSection.write(person);
        }
    }
}
