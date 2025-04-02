/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:44. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.placeImage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageConverter;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageConverterImpl;
import scot.carricksoftware.grants.domains.images.PlaceImage;
import scot.carricksoftware.grants.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class PlaceImageConverterTest {

    private PlaceImageConverter converter;

    @BeforeEach
    void setUp() {
        converter = new PlaceImageConverterImpl();
    }

    @Test
    void covertTest() {
        Long Id = GetRandomLong();
        Place place = GetRandomPlace();

        PlaceImage source = new PlaceImage();

        source.setId(Id);
        source.setPlace(place);

        PlaceImageCommand target = converter.convert(source);

        assertNotNull(target);
        assertEquals(Id, target.getId());
        assertEquals(place, target.getPlace());
    }
}