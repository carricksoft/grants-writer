/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:42. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.text;

import scot.carricksoftware.grants.domains.places.Place;

public interface PlaceTextCommand {
    Long getId();

    void setId(Long id);

    Place getPlace();

    void setPlace(Place place);
}
