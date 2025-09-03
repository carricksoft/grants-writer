/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.text.PersonText;
import scot.carricksoftware.grantswriter.repositories.text.PersonTextRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class PersonTextServiceImpl implements PersonTextService {

    private static final Logger logger = LogManager.getLogger(PersonTextServiceImpl.class);

    private final PersonTextRepository personTextRepository;

    public PersonTextServiceImpl(PersonTextRepository personTextRepository) {
        this.personTextRepository = personTextRepository;
    }

    @Override
    public List<PersonText> findAllByPerson(Person person) {
        logger.debug("PersonServiceImpl::findAllByPerson");
        List<PersonText> result = new ArrayList<>();
        Iterable<PersonText> personTextIterable = personTextRepository.findAllByPerson(person);
        for (PersonText personText : personTextIterable) {
            result.add(personText);
        }
        return result;
    }
}
