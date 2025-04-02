/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.places.places;


import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.domains.places.Place;

@Component
public class PlaceCommandConverterImpl implements PlaceCommandConverter {

    @Override
    public Place convert(@NotNull PlaceCommand source) {
        Place target = new Place();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setRegion(source.getRegion());
        target.setCensuses(source.getCensuses());
        return target;
    }


}
