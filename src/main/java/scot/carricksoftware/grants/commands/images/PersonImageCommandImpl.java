/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 09:59. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.images;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.people.Person;

@Component
public class PersonImageCommandImpl implements PersonImageCommand{
    Long Id;

    Person person;

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public void setId(Long id) {
        Id = id;
    }

    @Override
    public Person getPerson() {
        return person;
    }

    @Override
    public void setPerson(Person person) {
        this.person = person;
    }
}
