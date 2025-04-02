/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:22. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.text;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.places.Place;


@Entity
public class PlaceText extends BaseEntity {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
