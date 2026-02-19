/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

class PlaceTextTest {

    private PlaceText placeText;

    @BeforeEach
    void setUp() {
        placeText = new PlaceText();
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

    @Test
    void getLevelTest() {
        assertNull(placeText.getLevel());
    }

    @Test
    void setLevelTest() {
        String level = GetRandomString();
        placeText.setLevel(level);
        assertEquals(level, placeText.getLevel());
    }

    @Test
    void getOrderTest() {
        assertNull(placeText.getOrder());
    }

    @Test
    void setOrderTest() {
        String order = GetRandomString();
        placeText.setOrder(order);
        assertEquals(order, placeText.getOrder());
    }

    @Test
    void getHeadingTest() {
        assertNull(placeText.getHeading());
    }

    @Test
    void setHeadingTest() {
        String heading = GetRandomString();
        placeText.setHeading(heading);
        assertEquals(heading, placeText.getHeading());
    }

    @Test
    void getContentTest() {
        assertNull(placeText.getContent());
    }

    @Test
    void setContentTest() {
        String content = GetRandomString();
        placeText.setContent(content);
        assertEquals(content, placeText.getContent());
    }

}