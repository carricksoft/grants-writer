/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter;


import scot.carricksoftware.grantswriter.domains.places.Country;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.domains.places.Region;

import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@SuppressWarnings("unused")

public class GenerateRandomPlaceValues {

    @SuppressWarnings("unused")
    public static Place GetRandomPlace() {
        Place place = new Place();
        place.setName(GetRandomString());
        return place;
    }

    public static Country GetRandomCountry() {
        Country country = new Country();
        country.setName(GetRandomString());
        return country;
    }

    public static Region GetRandomRegion() {
        Region region = new Region();
        region.setName(GetRandomString());
        return region;
    }



}
