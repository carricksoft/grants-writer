/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 17:17. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.places.countries;


import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.places.Region;

import java.util.List;

@Component
public class CountryCommandImpl implements CountryCommand {

    private Long id;

    private String name;

    private List<Region> regions;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Region> getRegions() {
        return regions;
    }

    @Override
    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
