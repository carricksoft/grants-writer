/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:42. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


@ExtendWith(MockitoExtension.class)
public class CensusRoomsTest {

    private Census census;

    @BeforeEach
    public void setUp() {
        census = new Census();
    }

    @Test
    public void getInhabitedRoomsTest() {
        assertNull(census.getInhabitedRooms());
    }

    @Test
    public void setInhabitedRoomsTest() {
        String string = GetRandomString();
        census.setInhabitedRooms(string);
        assertEquals(string, census.getInhabitedRooms());
    }

    @Test
    public void getRoomsWithWidowsTest() {
        assertNull(census.getRoomsWithWindows());
    }

    @Test
    public void setRoomsWithWidowsTest() {
        String string = GetRandomString();
        census.setRoomsWithWindows(string);
        assertEquals(string, census.getRoomsWithWindows());
    }


}
