/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 14:34.
 *
 */

package scot.carricksoftware.grantswriter.domains.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomCountry;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;


public class RegionTest {

    Region region;

    @BeforeEach
    public void setUp() {
        region = new Region();
    }

    @Test
    public void getNameTest() {
        assertNull(region.getName());
    }

    @Test
    public void setNameTest() {
        String name = GetRandomString();
        region.setName(name);
        assertEquals(name, region.getName());
    }

    @Test
    public void getCountryTest() {
        assertNull(region.getCountry());
    }

    @Test
    public void setCountryTest() {
        Country country = GetRandomCountry();
        region.setCountry(country);
        assertEquals(country, region.getCountry());
    }

    @Test
    public void getPlacesTest() {
        assertTrue(region.getPlaces().isEmpty());
    }

    @Test
    public void setRegionsTest() {
        List<Place> places = new ArrayList<>();
        places.add(GetRandomPlace());
        region.setPlaces(places);
        assertEquals(places, region.getPlaces());
    }

}
