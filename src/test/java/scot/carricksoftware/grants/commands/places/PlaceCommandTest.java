/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 17:52. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;

import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.commands.places.places.PlaceCommandImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.places.Region;

import java.util.ArrayList;
import java.util.List;

public class PlaceCommandTest {

    PlaceCommand command;

    @BeforeEach
    public void setUp() {
        command = new PlaceCommandImpl();
    }

    @Test
    public void getIdTest() {
        assertNull(command.getId());
    }

    @Test
    public void setIdTest() {
        Long Id = GetRandomLong();
        command.setId(Id);
        assertEquals(Id, command.getId());
    }

    @Test
    public void getNameTest() {
        assertNull(command.getName());
    }

    @Test
    public void setNameTest() {
        String name = GetRandomString();
        command.setName(name);
        assertEquals(name, command.getName());
    }


    @Test
    public void getRegionTest() {
        assertNull(command.getName());
    }

    @Test
    public void setRegionTest() {
        Region region = GetRandomRegion();
        command.setRegion(region);
        assertEquals(region, command.getRegion());
    }

    @Test
    public void getCensusesTest() {
        assertTrue(command.getCensuses().isEmpty());
    }

    @Test
    public void setCensusesTest() {
        List<Census> censuses = new ArrayList<>();
        censuses.add(GetRandomCensus());
        command.setCensuses(censuses);
        assertEquals(censuses, command.getCensuses());
    }


}