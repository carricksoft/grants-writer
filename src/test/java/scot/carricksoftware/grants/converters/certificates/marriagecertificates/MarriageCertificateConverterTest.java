/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class MarriageCertificateConverterTest {

    private MarriageCertificateConverter converter;

    @BeforeEach
    void setUp() {
        converter = new MarriageCertificateConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        Person bride = GetRandomPerson();
        Person groom = GetRandomPerson();
        MarriageCertificate source = new MarriageCertificate();

        source.setId(id);
        source.setBride(bride);
        source.setGroom(groom);

        MarriageCertificateCommand target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(bride, target.getBride());
        assertEquals(groom, target.getGroom());
    }
}