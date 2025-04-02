/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 23:57. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.images;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.places.Place;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class PlaceImageCommandTest {

    private PlaceImageCommand imageCommand;

    @BeforeEach
    void setUp() {
        imageCommand = new PlaceImageCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(imageCommand.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        imageCommand.setId(id);
        assertEquals(id, imageCommand.getId());
    }


    @Test
    void getPlaceTest() {
        assertNull(imageCommand.getPlace());
    }

    @Test
    void  setPlaceTest() {
        Place place = GetRandomPlace();
        imageCommand.setPlace(place);
        assertEquals(place, imageCommand.getPlace());
    }


}