/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@Component
public class AttributeConstants {

    private AttributeConstants() {
        // to stop checkstyle complaining
    }

    @SuppressWarnings("unused")
    public static final String PEOPLE = "people";
    @SuppressWarnings("unused")
    public static final String PERSON_COMMAND = "personCommand";

    public static final String COUNTRIES = "countries";
    @SuppressWarnings("unused")
    public static final String COUNTRY_COMMAND = "countryCommand";

    @SuppressWarnings("unused")
    public static final String REGIONS = "regions";
    @SuppressWarnings("unused")
    public static final String REGION_COMMAND = "regionCommand";

    @SuppressWarnings("unused")
    public static final String PLACES = "places";
    @SuppressWarnings("unused")
    public static final String PLACE_COMMAND = "placeCommand";

    @SuppressWarnings("unused")
    public static final String CENSUSES = "censuses";
    @SuppressWarnings("unused")
    public static final String CENSUS_COMMAND = "censusCommand";

    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRIES = "censusEntries";
    @SuppressWarnings("unused")
    public static final String CENSUS_ENTRY_COMMAND = "censusEntryCommand";

    @SuppressWarnings({"unused"})
    public static final String BIRTH_CERTIFICATES = "birthCertificates";
    @SuppressWarnings({"unused"})
    public static final String BIRTH_CERTIFICATE_COMMAND = "birthCertificateCommand";

    @SuppressWarnings({"unused"})
    public static final String DEATH_CERTIFICATES = "deathCertificates";
    @SuppressWarnings({"unused"})
    public static final String DEATH_CERTIFICATE_COMMAND = "deathCertificateCommand";

    @SuppressWarnings({"unused"})
    public static final String MARRIAGE_CERTIFICATES = "marriageCertificates";
    @SuppressWarnings({"unused"})
    public static final String MARRIAGE_CERTIFICATE_COMMAND = "marriageCertificateCommand";

    @SuppressWarnings({"unused"})
    public static final String DIVORCE_CERTIFICATES = "divorceCertificates";
    @SuppressWarnings({"unused"})
    public static final String DIVORCE_CERTIFICATE_COMMAND = "divorceCertificateCommand";
}
