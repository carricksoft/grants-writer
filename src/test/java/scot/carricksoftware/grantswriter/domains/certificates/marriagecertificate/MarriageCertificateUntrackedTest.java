/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


class MarriageCertificateUntrackedTest {

    private MarriageCertificate marriageCertificate;
    private String string;

    @BeforeEach
    void setUp() {
        marriageCertificate = new MarriageCertificate();
        string = GetRandomString();
    }

    @Test
    void getUntrackedWhereMarriedTest() {
        assertNull(marriageCertificate.getUntrackedWhereMarried());
    }

    @Test
    void setUntrackedWhereMarriedTest() {
        marriageCertificate.setUntrackedWhereMarried(string);
        assertEquals(string, marriageCertificate.getUntrackedWhereMarried());
    }

    @Test
    void getGroomUntrackedResidenceTest() {
        assertNull(marriageCertificate.getGroomUntrackedResidence());
    }

    @Test
    void setGroomUntrackedResidenceTest() {
        marriageCertificate.setGroomUntrackedResidence(string);
        assertEquals(string, marriageCertificate.getGroomUntrackedResidence());
    }

    @Test
    void getBrideUntrackedResidenceTest() {
        assertNull(marriageCertificate.getBrideUntrackedResidence());
    }

    @Test
    void setBrideUntrackedResidenceTest() {
        marriageCertificate.setBrideUntrackedResidence(string);
        assertEquals(string, marriageCertificate.getBrideUntrackedResidence());
    }


}