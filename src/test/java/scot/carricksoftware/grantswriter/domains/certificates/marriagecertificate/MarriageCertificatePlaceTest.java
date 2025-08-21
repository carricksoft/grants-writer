/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;


class MarriageCertificatePlaceTest {

    private MarriageCertificate marriageCertificate;
    private Place place;

    @BeforeEach
    void setUp() {
        marriageCertificate = new MarriageCertificate();
        place = GetRandomPlace();
    }

    @Test
    void getWhereMarriedTest() {
        assertNull(marriageCertificate.getWhereMarried());
    }

    @Test
    void setWhereMarriedTest() {
        marriageCertificate.setWhereMarried(place);
        assertEquals(place, marriageCertificate.getWhereMarried());
    }


    @Test
    void getBrideUsualResidenceTest() {
        assertNull(marriageCertificate.getBrideUsualResidence());
    }

    @Test
    void setBrideUsualResidenceTest() {
        marriageCertificate.setBrideUsualResidence(place);
        assertEquals(place, marriageCertificate.getBrideUsualResidence());
    }


}