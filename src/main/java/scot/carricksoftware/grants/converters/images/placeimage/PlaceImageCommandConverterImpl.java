/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.placeimage;


import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.domains.images.PlaceImage;

@Component
public class PlaceImageCommandConverterImpl implements PlaceImageCommandConverter {

    @Override
    public PlaceImage convert(@NotNull PlaceImageCommand source) {
        PlaceImage target = new PlaceImage();
        target.setId(source.getId());
        target.setPlace(source.getPlace());
        return target;
    }


}
