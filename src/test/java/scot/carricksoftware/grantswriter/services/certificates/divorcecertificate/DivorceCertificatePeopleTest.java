/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.divorcecertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.certificates.divorcecertificate.DivorceCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;


class DivorceCertificatePeopleTest {

    private DivorceCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new DivorceCertificate();
    }

    @Test
    public void getFirstPartyTest() {
        assertNull(certificate.getFirstParty());
    }

    @Test
    public void setFirstPartyTest() {
        Person person = GetRandomPerson();
        certificate.setFirstParty(person);
        assertEquals(person, certificate.getFirstParty());
    }

    @Test
    public void getSecondPartyTest() {
        assertNull(certificate.getSecondParty());
    }

    @Test
    public void setSecondPartyTest() {
        Person person = GetRandomPerson();
        certificate.setSecondParty(person);
        assertEquals(person, certificate.getSecondParty());
    }




}