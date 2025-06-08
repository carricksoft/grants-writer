/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.images.Image;
import scot.carricksoftware.grantswriter.domains.images.PersonImage;
import scot.carricksoftware.grantswriter.domains.images.PlaceImage;

import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;


@SuppressWarnings("unused")
@Component
public class GenerateRandomImageValues {

    @SuppressWarnings("unused")
    public static Image GetRandomImage() {
        Image image = new Image();
        image.setId(GetRandomLong());
        return image;
    }


    @SuppressWarnings("unused")
    public static PersonImage GetRandomPersonImage() {
        PersonImage image = new PersonImage();
        image.setId(GetRandomLong());
        return image;
    }


    @SuppressWarnings("unused")
    public static PlaceImage GetRandomPlaceImage() {
        PlaceImage image = new PlaceImage();
        image.setId(GetRandomLong());
        return image;
    }



}
