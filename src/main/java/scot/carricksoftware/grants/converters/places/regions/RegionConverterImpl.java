/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.places.regions;


import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.commands.places.regions.RegionCommandImpl;
import scot.carricksoftware.grants.domains.places.Region;

@Component
public class RegionConverterImpl implements RegionConverter {

    @Override
    public RegionCommand convert(Region source) {
        RegionCommand target = new RegionCommandImpl();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setCountry(source.getCountry());
        target.setPlaces(source.getPlaces());
        return target;
    }
}
