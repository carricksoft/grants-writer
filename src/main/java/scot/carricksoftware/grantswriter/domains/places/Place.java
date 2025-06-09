/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter.domains.places;


import jakarta.persistence.*;
import scot.carricksoftware.grantswriter.BaseEntity;

@Entity
public class Place extends BaseEntity {

    @Column(name = "`name`")
    private String name;

    @ManyToOne
    @JoinColumn(name = "`region_id`")
    private Region region;

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return name +
                ", " + region.getName() +
                ", " + region.getCountry().getName();
    }
}
