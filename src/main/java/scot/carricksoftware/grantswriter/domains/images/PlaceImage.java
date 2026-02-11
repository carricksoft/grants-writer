/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:50. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.images;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import scot.carricksoftware.grantswriter.domains.places.Place;


@Entity(name="place_image")
@Table(name="`place_image`")
public class PlaceImage extends BaseImage {


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
