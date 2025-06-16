/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.places.Country;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.domains.places.Region;

import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


@SuppressWarnings("unused")
@Component
public class GenerateRandomPlaceValues {

    @SuppressWarnings("unused")
    public static Place GetRandomPlace() {
        Place place = new Place();
        place.setName(GetRandomString());
        place.setRegion(GetRandomRegion());
        return place;
    }

    public static Region GetRandomRegion() {
        Region region = new Region();
        region.setName(GetRandomString());
        region.setCountry(GetRandomCountry());
        return region;
    }

    public static Country GetRandomCountry() {
        Country country = new Country();
        country.setName(GetRandomString());
        return country;
    }


}
