/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.places;


import jakarta.persistence.*;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.census.Census;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Place extends BaseEntity {

    private String name;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "place_region_id")
    private Region region;

    @SuppressWarnings("unused")
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Census> censuses = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Census> getCensuses() {
        return censuses;
    }

    public void setCensuses(List<Census> censuses) {
        this.censuses = censuses;
    }

    @Override
    public String toString() {
        return name +
                ", " + region.getName() +
                ", " + region.getCountry().getName();
    }
}
