/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:28. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.places.Place;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;


class PlaceTextTest {

    private PlaceText placeText;

    @BeforeEach
    void setUp() {
        placeText = new PlaceText();
    }

    @Test
    void getIdTest() {
        Long id = GetRandomLong();
        placeText.setId(id);
        assertNotNull(placeText.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        placeText.setId(id);
        assertEquals(id, placeText.getId());
    }

    @Test
    void getPlaceTest() {
        assertNull(placeText.getPlace());
    }

    @Test
    void setPlaceTest() {
        Place place = GetRandomPlace();
        placeText.setPlace(place);
        assertEquals(place, placeText.getPlace());
    }

}