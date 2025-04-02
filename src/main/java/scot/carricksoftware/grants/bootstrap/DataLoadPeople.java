/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;


@Component
public class DataLoadPeople {

    private static final Logger logger = LogManager.getLogger(DataLoadPeople.class);

    private final PersonService personService;

    public DataLoadPeople(PersonService personService) {
        this.personService = personService;
    }

    public void load() {
        logger.debug("DataLoadPlaces::load");
        loadDad();
        loadMum();
    }

    private void loadDad() {
        final Person dad = new Person();
        dad.setFirstName("Andrew");
        dad.setLastName("Grant");
        personService.save(dad);
    }

    private void loadMum() {
        final Person mum = new Person();
        mum.setFirstName("Dorothy");
        mum.setLastName("Bramall");
        personService.save(mum);

    }


}
