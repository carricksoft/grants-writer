/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.people;

import scot.carricksoftware.grantswriter.domains.people.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

}
