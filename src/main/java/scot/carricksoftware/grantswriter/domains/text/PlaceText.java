/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:22. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.text;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import scot.carricksoftware.grantswriter.domains.places.Place;


@Entity(name="place_text")
@Table(name="`place_text`")
public class PlaceText extends BaseText {

    @ManyToOne
    @JoinColumn(name = "`place_id`")
    private Place place;

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
