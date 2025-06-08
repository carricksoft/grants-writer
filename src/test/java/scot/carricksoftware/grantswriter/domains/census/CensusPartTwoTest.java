/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:42. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


@ExtendWith(MockitoExtension.class)
public class CensusPartTwoTest {

    private Census census;

    @BeforeEach
    public void setUp() {
        census = new Census();
    }

    @Test
    public void getFilledInByTest() {
        assertNull(census.getFilledInBy());
    }

    @Test
    public void setFilledInByTest() {
        String filledInBy = GetRandomString();
        census.setFilledInBy(filledInBy);
        assertEquals(filledInBy, census.getFilledInBy());
    }

    @Test
    public void getTotalRoomsTest() {
        assertNull(census.getTotalRooms());
    }

    @Test
    public void setTotalRoomsTest() {
        String totalRooms = GetRandomString();
        census.setTotalRooms(totalRooms);
        assertEquals(totalRooms, census.getTotalRooms());
    }

    @Test
    public void getRoomsOccupiedTest() {
        assertNull(census.getRoomsOccupied());
    }

    @Test
    public void setRoomOccupiedTest() {
        String roomsOccupied = GetRandomString();
        census.setRoomsOccupied(roomsOccupied);
        assertEquals(roomsOccupied, census.getRoomsOccupied());
    }

    @Test
    public void getInhabitedHousesTest() {
        assertNull(census.getInhabitedRooms());
    }

    @Test
    public void setInhabitedHousesTest() {
        String inhabitedHouses = GetRandomString();
        census.setInhabitedHouses(inhabitedHouses);
        assertEquals(inhabitedHouses, census.getInhabitedHouses());
    }


    @Test
    public void getUninhabitedHousesTest() {
        assertNull(census.getUninhabitedHouses());
    }

    @Test
    public void setUninhabitedHousesTest() {
        String uninhabitedHouses = GetRandomString();
        census.setUninhabitedHouses(uninhabitedHouses);
        assertEquals(uninhabitedHouses, census.getUninhabitedHouses());
    }

    @Test
    public void getPeopleInHousesTest() {
        assertNull(census.getUninhabitedHouses());
    }

    @Test
    public void setPeopleInHousesTest() {
        String string = GetRandomString();
        census.setPeopleInHouses(string);
        assertEquals(string, census.getPeopleInHouses());
    }


}
