/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.places.places;

import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.places.Region;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class PlaceCommandImpl implements PlaceCommand {
    private Long id;

    private Region region;

    private String name;

    private List<Census> censuses = new ArrayList<>();


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
    public Region getRegion() {
        return region;
    }

    @Override
    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public List<Census> getCensuses() {
        return censuses;
    }

    @Override
    public void setCensuses(List<Census> censuses) {
        this.censuses = censuses;
    }
}
