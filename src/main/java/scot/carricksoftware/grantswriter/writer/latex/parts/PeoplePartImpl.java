/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.people.PersonService;
import scot.carricksoftware.grantswriter.writer.latex.sections.PersonSection;

import java.util.List;

@Component
public class PeoplePartImpl implements PeoplePart {

    private static final Logger logger = LogManager.getLogger(PeoplePartImpl.class);

    private final PersonService personService;

    private final PersonSection personSection;

    public PeoplePartImpl(PersonService personService, PersonSection personSection) {
        this.personService = personService;
        this.personSection = personSection;
    }

    @Override
    public void write() {
        logger.info("PeoplePartsImpl.write()");
        List<Person> people = personService.findAll();
        for (Person person : people) {
            personSection.write(person);
        }
    }
}
