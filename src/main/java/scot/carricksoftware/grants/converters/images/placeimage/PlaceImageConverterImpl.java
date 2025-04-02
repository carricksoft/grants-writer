/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.placeimage;


import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.commands.images.PlaceImageCommandImpl;
import scot.carricksoftware.grants.domains.images.PlaceImage;

@Component
public class PlaceImageConverterImpl implements PlaceImageConverter {

    @Override
    public PlaceImageCommand convert(PlaceImage source) {
        PlaceImageCommand target = new PlaceImageCommandImpl();
        target.setId(source.getId());
        target.setPlace(source.getPlace());
        return target;
    }
}
