/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter.domains.places;


import jakarta.persistence.*;
import scot.carricksoftware.grantswriter.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Region extends BaseEntity {

    @Column(name = "`name`")
    private String name;

    @ManyToOne
    @JoinColumn(name = "`country_id`")
    private Country country;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Place> places = new ArrayList<>();

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @SuppressWarnings("unused")
    public List<Place> getPlaces() {
        return places;
    }

    @SuppressWarnings("unused")
    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
