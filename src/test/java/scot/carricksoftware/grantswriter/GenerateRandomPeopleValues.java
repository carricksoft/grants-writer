/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;

import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomString;


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


}
