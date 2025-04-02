/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.commands.people.PersonCommandImpl;
import scot.carricksoftware.grants.domains.people.Person;

import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@SuppressWarnings("unused")
@Component
public class GenerateRandomPeopleValues {

    @SuppressWarnings("unused")
    public static Person GetRandomPerson() {
        Person person = new Person();
        person.setId(GetRandomLong());
        person.setFirstName(GetRandomString());
        person.setLastName(GetRandomString());
        return person;
    }

    public static PersonCommand GetRandomPersonCommand() {
        PersonCommand personCommand = new PersonCommandImpl();
        personCommand.setId(GetRandomLong());
        personCommand.setFirstName(GetRandomString());
        personCommand.setLastName(GetRandomString());
        return personCommand;
    }

}
