/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter;


import scot.carricksoftware.grantswriter.domains.people.Person;

import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

@SuppressWarnings("unused")


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
