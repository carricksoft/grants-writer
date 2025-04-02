/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.regions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.commands.places.regions.RegionCommandImpl;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomCountry;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;


public class RegionCensusCommandConverterImplTest {

    final RegionCommandConverterImpl converter = new RegionCommandConverterImpl();
    RegionCommand source;

    @BeforeEach
    public void setUp() {
        source = new RegionCommandImpl();
    }

    @Test
    public void convert() {
        Long id = GetRandomLong();
        String name = GetRandomString();
        Country country = GetRandomCountry();
        List<Place> places = new ArrayList<>();
        places.add(GetRandomPlace());

        source.setId(id);
        source.setName(name);
        source.setCountry(country);
        source.setPlaces(places);

        Region target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());
        assertEquals(country, target.getCountry());
        assertEquals(places, target.getPlaces());
    }
}