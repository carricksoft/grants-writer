/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.people.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Logger logger = LogManager.getLogger(PersonServiceImpl.class);

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        logger.debug("PersonServiceImpl::findAll");
        List<Person> result = new ArrayList<>();
        Iterable<Person> personIterable = personRepository.findAll(getSort());
        personIterable.forEach(result::add);
        return result;
    }

    private Sort getSort() {
        return Sort.by(
                Sort.Order.asc("lastName"),
                Sort.Order.asc("firstName"));
    }

}
