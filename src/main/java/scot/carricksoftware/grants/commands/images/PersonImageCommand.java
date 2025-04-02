/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 09:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.images;

import scot.carricksoftware.grants.domains.people.Person;

public interface PersonImageCommand {
    Long getId();

    void setId(Long id);

    Person getPerson();

    void setPerson(Person person);
}
