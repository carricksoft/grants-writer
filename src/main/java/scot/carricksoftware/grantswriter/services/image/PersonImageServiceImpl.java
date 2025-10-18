/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.image;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.domains.images.PersonImage;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.images.PersonImageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonImageServiceImpl implements PersonImageService {

    private static final Logger logger = LogManager.getLogger(PersonImageServiceImpl.class);

    private final PersonImageRepository personImageRepository;

    public PersonImageServiceImpl(PersonImageRepository personImageRepository) {
        this.personImageRepository = personImageRepository;
    }

    @Override
    public List<PersonImage> findAllByPerson(Person person) {
        logger.debug("PersonServiceImpl::findAllByPerson");
        List<PersonImage> result = new ArrayList<>();
        Iterable<PersonImage> personImageIterable = personImageRepository.findAllByPerson(person);
        for (PersonImage personImage : personImageIterable) {
            result.add(personImage);
        }
        return result;
    }

    @Override
    public PersonImage findById(Long id) {
        return personImageRepository.findById(id);
    }
}
