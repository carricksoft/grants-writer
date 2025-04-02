/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:05. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class PlaceTextCommandTest {

    private PlaceTextCommand placeTextCommand;

    @BeforeEach
    void setUp() {
        placeTextCommand = new PlaceTextCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(placeTextCommand.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        placeTextCommand.setId(id);
        assertEquals(id, placeTextCommand.getId());
    }

    @Test
    void getPlaceTest() {
        assertNull(placeTextCommand.getPlace());
    }

    @Test
    void setPlaceTest() {
        Place place = GetRandomPlace();
        placeTextCommand.setPlace(place);
        assertEquals(place, placeTextCommand.getPlace());
    }


}