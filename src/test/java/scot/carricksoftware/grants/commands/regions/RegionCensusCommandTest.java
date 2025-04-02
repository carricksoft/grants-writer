/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 17:53. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.regions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.commands.places.regions.RegionCommandImpl;
import scot.carricksoftware.grants.domains.places.Country;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomCountry;

class RegionCensusCommandTest {

    RegionCommand command;

    @BeforeEach
    void setUp() {
        command = new RegionCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(command.getId());
    }

    @Test
    void setIdTest() {
        Long Id = GetRandomLong();
        command.setId(Id);
        assertEquals(Id, command.getId());
    }

    @Test
    void getNameTest() {
        assertNull(command.getName());
    }

    @Test
    void setNameTest() {
        String name = GetRandomString();
        command.setName(name);
        assertEquals(name, command.getName());
    }

    @Test
    public void getCountryTest() {
        assertNull(command.getCountry());
    }

    @Test
    public void setCountryTest() {
        Country country = GetRandomCountry();
        command.setCountry(country);
        assertEquals(country, command.getCountry());
    }


}