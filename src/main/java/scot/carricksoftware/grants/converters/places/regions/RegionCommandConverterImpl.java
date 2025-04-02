/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.places.regions;


import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.domains.places.Region;

@Component
public class RegionCommandConverterImpl implements RegionCommandConverter {

    @Override
    public Region convert(@NotNull RegionCommand source) {
        Region target = new Region();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setCountry(source.getCountry());
        target.setPlaces(source.getPlaces());
        return target;
    }


}
