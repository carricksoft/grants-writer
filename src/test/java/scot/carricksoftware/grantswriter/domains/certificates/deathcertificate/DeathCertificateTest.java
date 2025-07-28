/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.deathcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.enums.general.Sex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


class DeathCertificateTest {

    private DeathCertificate deathCertificate;

    @BeforeEach
    void setUp() {
        deathCertificate = new DeathCertificate();
    }


    @Test
    void getSexTest() {
        assertNull(deathCertificate.getSex());
    }

    @Test
    void setSexTest() {
        Sex sex = Sex.MALE;
        deathCertificate.setSex(sex);
        assertEquals(sex, deathCertificate.getSex());
    }

    @Test
    void getOccupationTest() {
        assertNull(deathCertificate.getOccupation());
    }

    @Test
    void setOccupationTest() {
        String occupation = GetRandomString();
        deathCertificate.setOccupation(occupation);
        assertEquals(occupation, deathCertificate.getOccupation());
    }

    @Test
    void getSpouseOccupationTest() {
        assertNull(deathCertificate.getSpouseOccupation());
    }

    @Test
    void setSpouseOccupationTest() {
        String spouseOccupation = GetRandomString();
        deathCertificate.setSpouseOccupation(spouseOccupation);
        assertEquals(spouseOccupation, deathCertificate.getSpouseOccupation());
    }

    @Test
    void getFatherOccupationTest() {
        assertNull(deathCertificate.getFatherOccupation());
    }

    @Test
    void setFatherOccupationTest() {
        String fatherOccupation = GetRandomString();
        deathCertificate.setFatherOccupation(fatherOccupation);
        assertEquals(fatherOccupation, deathCertificate.getFatherOccupation());
    }

    @Test
    void getMotherOccupationTest() {
        assertNull(deathCertificate.getMotherOccupation());
    }

    @Test
    void setMotherOccupationTest() {
        String motherOccupation = GetRandomString();
        deathCertificate.setMotherOccupation(motherOccupation);
        assertEquals(motherOccupation, deathCertificate.getMotherOccupation());
    }

    @Test
    void getMaritalStatusTest() {
        assertNull(deathCertificate.getMaritalStatus());
    }

    @Test
    void setMaritalStatusTest() {
        String maritalStatus = GetRandomString();
        deathCertificate.setMaritalStatus(maritalStatus);
        assertEquals(maritalStatus, deathCertificate.getMaritalStatus());
    }


}