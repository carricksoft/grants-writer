/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 09:54. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.images;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;


class PlaceImageTest {

    private PlaceImage placeImage;

    @BeforeEach
    void setUp() {
        placeImage = new PlaceImage();
    }

    @Test
    public void getIdTest() {
        assertNull(placeImage.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        placeImage.setId(id);
        assertEquals(id, placeImage.getId());
    }

    @Test
    public void getPlaceTest() {
        assertNull(placeImage.getPlace());
    }

    @Test
    public void setPlaceTest() {
        Place place = GetRandomPlace();
        placeImage.setPlace(place);
        assertEquals(place, placeImage.getPlace());
    }

}