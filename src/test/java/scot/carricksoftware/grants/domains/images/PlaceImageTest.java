/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 09:54. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.images;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class PlaceImageTest {

private PlaceImage image;

    @BeforeEach
    void setUp() {
        image = new PlaceImage();
    }

    @Test
    public void getIdTest() {
        assertNull(image.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        image.setId(id);
        assertEquals(id, image.getId());
    }

    @Test
    public void getPlaceTest() {
        assertNull(image.getPlace());
    }

    @Test
    public  void setPlaceTest() {
        Place place = GetRandomPlace();
        image.setPlace(place);
        assertEquals(place, image.getPlace());
    }

}