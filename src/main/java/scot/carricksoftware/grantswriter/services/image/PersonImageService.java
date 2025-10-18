/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.image;


import scot.carricksoftware.grantswriter.domains.images.PersonImage;
import scot.carricksoftware.grantswriter.domains.people.Person;

import java.util.List;

public interface PersonImageService {
    List<PersonImage> findAllByPerson(Person person);
    PersonImage findById(Long id);
}
