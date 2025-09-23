/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.deathcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


class DeathCertificateUntrackedTest {

    private DeathCertificate deathCertificate;

    @BeforeEach
    void setUp() {
        deathCertificate = new DeathCertificate();
    }

    @Test
    void getUntrackedWhereDied() {
        assertNull(deathCertificate.getUntrackedWhereDied());
    }

    @Test
    void setUntrackedWhereDied() {
        String untrackedWhereDied = GetRandomString();
        deathCertificate.setUntrackedWhereDied(untrackedWhereDied);
        assertEquals(untrackedWhereDied, deathCertificate.getUntrackedWhereDied());
    }

    @Test
    void getUntrackedSpouse() {
        assertNull(deathCertificate.getUntrackedSpouse());
    }

    @Test
    void setUntrackedSpouse() {
        String untrackedSpouse = GetRandomString();
        deathCertificate.setUntrackedSpouse(untrackedSpouse);
        assertEquals(untrackedSpouse, deathCertificate.getUntrackedSpouse());
    }

    @Test
    void getUntrackedFather() {
        assertNull(deathCertificate.getUntrackedFather());
    }

    @Test
    void setUntrackedFather() {
        String untrackedFather = GetRandomString();
        deathCertificate.setUntrackedFather(untrackedFather);
        assertEquals(untrackedFather, deathCertificate.getUntrackedFather());
    }

    @Test
    void getUntrackedMother() {
        assertNull(deathCertificate.getUntrackedMother());
    }

    @Test
    void setUntrackedMother() {
        String untrackedMother = GetRandomString();
        deathCertificate.setUntrackedMother(untrackedMother);
        assertEquals(untrackedMother, deathCertificate.getUntrackedMother());
    }

    @Test
    void getUntrackedInformant() {
        assertNull(deathCertificate.getUntrackedInformant());
    }

    @Test
    void setUntrackedInformant() {
        String untrackedInformant = GetRandomString();
        deathCertificate.setUntrackedInformant(untrackedInformant);
        assertEquals(untrackedInformant, deathCertificate.getUntrackedInformant());
    }

    @Test
    void getUntrackedUsualResidence() {
        assertNull(deathCertificate.getUntrackedUsualResidence());
    }

    @Test
    void setUntrackedUsualResidence() {
        String untrackedUsualResidence = GetRandomString();
        deathCertificate.setUntrackedUsualResidence(untrackedUsualResidence);
        assertEquals(untrackedUsualResidence, deathCertificate.getUntrackedUsualResidence());
    }
}