/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


class MarriageCertificateStringTest {

    private MarriageCertificate marriageCertificate;
    private String string;

    @BeforeEach
    void setUp() {
        marriageCertificate = new MarriageCertificate();
        string = GetRandomString();
    }

    @Test
    void getUntrackedWhenMarriedTest() {
        assertNull(marriageCertificate.getWhenMarried());
    }

    @Test
    void setUntrackedWhenMarriedTest() {
        marriageCertificate.setWhenMarried(string);
        assertEquals(string, marriageCertificate.getWhenMarried());
    }

    @Test
    void getBrideRankTest() {
        assertNull(marriageCertificate.getBrideRank());
    }

    @Test
    void setBrideRankTest() {
        marriageCertificate.setBrideRank(string);
        assertEquals(string, marriageCertificate.getBrideRank());
    }

    @Test
    void getGroomRankTest() {
        assertNull(marriageCertificate.getGroomRank());
    }

    @Test
    void setGroomRankTest() {
        marriageCertificate.setGroomRank(string);
        assertEquals(string, marriageCertificate.getGroomRank());
    }

}