/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.text;

import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.text.PersonText;
import scot.carricksoftware.grantswriter.repositories.ReadOnlyRepository;

@Repository
public interface PersonTextRepository extends ReadOnlyRepository<PersonText, Long> {

    Iterable<PersonText> findAllByPerson(Person person);
    PersonText findById(Long id);

}
