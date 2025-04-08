/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:34. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.census;

import jakarta.persistence.*;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Census extends BaseEntity {

    private LocalDate date;

    @OneToMany(mappedBy = "census", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CensusEntry> censusEntries = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "census_place_id")
    private Place place;


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<CensusEntry> getCensusEntries() {
        return censusEntries;
    }

    public void setCensusEntries(List<CensusEntry> censusEntries) {
        this.censusEntries = censusEntries;
    }

    @Override
    public String toString() {
        return place.toString() + ", " + date.toString();
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
