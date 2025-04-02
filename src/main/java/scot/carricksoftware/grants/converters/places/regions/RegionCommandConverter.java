/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.places.regions;


import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.domains.places.Region;

@Component
public interface RegionCommandConverter extends Converter<RegionCommand, Region> {

    @Override
    Region convert(@SuppressWarnings("NullableProblems") @NotNull RegionCommand source);


}
