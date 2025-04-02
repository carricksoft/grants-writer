/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 09:59. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.images;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.places.Place;

@Component
public class PlaceImageCommandImpl implements PlaceImageCommand{
    Long Id;

    Place place;

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public void setId(Long id) {
        Id = id;
    }

   @Override
   public Place getPlace() {
        return place;
    }

    @Override
    public void setPlace(Place place) {
        this.place = place;
    }
}
