/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 09:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.images;

import scot.carricksoftware.grants.domains.places.Place;

public interface PlaceImageCommand {
    Long getId();

    void setId(Long id);

    Place getPlace();

    void setPlace(Place place);
}
