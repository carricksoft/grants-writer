/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.*;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.domains.images.PersonImage;
import scot.carricksoftware.grants.domains.images.PlaceImage;

import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@SuppressWarnings("unused")
@Component
public class GenerateRandomImageValues {

    @SuppressWarnings("unused")
    public static Image GetRandomImage() {
        Image image = new Image();
        image.setId(GetRandomLong());
        return image;
    }

    public static ImageCommand GetRandomImageCommand() {
        ImageCommand imageCommand = new ImageCommandImpl();
        imageCommand.setId(GetRandomLong());
        return imageCommand;
    }

    @SuppressWarnings("unused")
    public static PersonImage GetRandomPersonImage() {
        PersonImage image = new PersonImage();
        image.setId(GetRandomLong());
        return image;
    }

    public static PersonImageCommand GetRandomPersonImageCommand() {
        PersonImageCommand imageCommand = new PersonImageCommandImpl();
        imageCommand.setId(GetRandomLong());
        return imageCommand;
    }

    @SuppressWarnings("unused")
    public static PlaceImage GetRandomPlaceImage() {
        PlaceImage image = new PlaceImage();
        image.setId(GetRandomLong());
        return image;
    }

    public static PlaceImageCommand GetRandomPlaceImageCommand() {
        PlaceImageCommand imageCommand = new PlaceImageCommandImpl();
        imageCommand.setId(GetRandomLong());
        return imageCommand;
    }

}
