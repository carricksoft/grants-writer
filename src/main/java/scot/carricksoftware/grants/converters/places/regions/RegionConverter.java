/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.places.regions;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.domains.places.Region;

@SuppressWarnings("unused")
@Component
public interface RegionConverter extends Converter<Region, RegionCommand> {

    @SuppressWarnings("NullableProblems")
    RegionCommand convert(Region source);
}
