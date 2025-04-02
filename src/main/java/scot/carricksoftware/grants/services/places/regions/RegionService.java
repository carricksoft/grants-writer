/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.places.regions;

import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.domains.places.Region;

import java.util.List;

@SuppressWarnings("unused")
public interface RegionService {

    @SuppressWarnings("unused")
    Region findById(Long id);

    @SuppressWarnings("unused")
    Region save(Region country);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<Region> getPagedRegions(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    RegionCommand saveRegionCommand(RegionCommand regionCommand);

    @SuppressWarnings("unused")
    List<Region> findAll();
}
