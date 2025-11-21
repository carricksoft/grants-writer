/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.census;

import jakarta.persistence.*;
import scot.carricksoftware.grantswriter.BaseEntity;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.enums.census.CensusDate;

@Entity
@Table(name="`census`")
public class Census extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "`census_date`")
    private CensusDate censusDate;

    @ManyToOne
    @JoinColumn(name = "`place_id`")
    private Place place;

    @Override
    public String toString() {
        return place.toString() + ", " + censusDate.label;
    }

    public CensusDate getCensusDate() {
        return censusDate;
    }

    public void setCensusDate(CensusDate censusDate) {
        this.censusDate = censusDate;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
