/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@Component
public class MappingConstants {

    private MappingConstants() {
        // to stop checkstyle complaining
    }

    @SuppressWarnings("unused")
    public static final String PEOPLE_LIST = "/people";
    @SuppressWarnings("unused")
    public static final String PEOPLE_NEXT = "/people/next";
    @SuppressWarnings("unused")
    public static final String PEOPLE_PREVIOUS = "/people/prev";
    @SuppressWarnings("unused")
    public static final String PEOPLE_REWIND = "/people/rewind";
    @SuppressWarnings("unused")
    public static final String PEOPLE_FF = "/people/ff";
    @SuppressWarnings("unused")
    public static final String PERSON_NEW = "/person/new";
    @SuppressWarnings("unused")
    public static final String PERSON = "/person";
    @SuppressWarnings("unused")
    public static final String PEOPLE = "/people";
    @SuppressWarnings("unused")
    public static final String PERSON_SHOW = "/person/{id}/show";
    @SuppressWarnings("unused")
    public static final String PERSON_DELETE = "/person/{id}/delete";
    @SuppressWarnings("unused")
    public static final String PERSON_EDIT = "/person/{id}/edit";
    public static final String REDIRECT = "redirect:";

    public static final String COUNTRY_LIST = "/countries";
    public static final String COUNTRY_NEXT = "/countries/next";
    public static final String COUNTRY_PREVIOUS = "/countries/prev";
    public static final String COUNTRY_REWIND = "/countries/rewind";
    public static final String COUNTRY_FF = "/countries/ff";
    @SuppressWarnings("unused")
    public static final String COUNTRY_NEW = "/country/new";
    @SuppressWarnings("unused")
    public static final String COUNTRY = "/country";
    public static final String COUNTRIES = "/countries";
    @SuppressWarnings("unused")
    public static final String COUNTRY_SHOW = "/country/{id}/show";
    public static final String COUNTRY_DELETE = "/country/{id}/delete";
    @SuppressWarnings("unused")
    public static final String COUNTRY_EDIT = "country/{id}/edit";

    @SuppressWarnings("unused")
    public static final String REGION_LIST = "/regions";
    @SuppressWarnings("unused")
    public static final String REGION_NEXT = "/regions/next";
    @SuppressWarnings("unused")
    public static final String REGION_PREVIOUS = "/regions/prev";
    @SuppressWarnings("unused")
    public static final String REGION_REWIND = "/regions/rewind";
    @SuppressWarnings("unused")
    public static final String REGION_FF = "/regions/ff";
    @SuppressWarnings("unused")
    public static final String REGION_NEW = "/region/new";
    @SuppressWarnings("unused")
    public static final String REGION = "/region";
    @SuppressWarnings("unused")
    public static final String REGIONS = "/regions";
    @SuppressWarnings("unused")
    public static final String REGION_SHOW = "/region/{id}/show";
    @SuppressWarnings("unused")
    public static final String REGION_DELETE = "/region/{id}/delete";
    @SuppressWarnings("unused")
    public static final String REGION_EDIT = "region/{id}/edit";

    @SuppressWarnings("unused")
    public static final String PLACE_LIST = "/places";
    @SuppressWarnings("unused")
    public static final String PLACE_NEXT = "/places/next";
    @SuppressWarnings("unused")
    public static final String PLACE_PREVIOUS = "/places/prev";
    @SuppressWarnings("unused")
    public static final String PLACE_REWIND = "/places/rewind";
    @SuppressWarnings("unused")
    public static final String PLACE_FF = "/places/ff";
    @SuppressWarnings("unused")
    public static final String PLACE_NEW = "/place/new";
    @SuppressWarnings("unused")
    public static final String PLACE = "/place";
    @SuppressWarnings("unused")
    public static final String PLACE_SHOW = "/place/{id}/show";
    @SuppressWarnings("unused")
    public static final String PLACE_DELETE = "/place/{id}/delete";
    @SuppressWarnings("unused")
    public static final String PLACE_EDIT = "place/{id}/edit";

    @SuppressWarnings("unused")
    public static final String CENSUS_LIST = "/censuses";
    @SuppressWarnings("unused")
    public static final String CENSUS_NEXT = "/censuses/next";
    @SuppressWarnings("unused")
    public static final String CENSUS_PREVIOUS = "/censuses/prev";
    @SuppressWarnings("unused")
    public static final String CENSUS_REWIND = "/censuses/rewind";
    @SuppressWarnings("unused")
    public static final String CENSUS_FF = "/censuses/ff";
    @SuppressWarnings("unused")
    public static final String CENSUS_NEW = "/census/new";
    @SuppressWarnings("unused")
    public static final String CENSUS = "/census";
    @SuppressWarnings("unused")
    public static final String CENSUS_SHOW = "/census/{id}/show";
    @SuppressWarnings("unused")
    public static final String CENSUS_DELETE = "/census/{id}/delete";
    @SuppressWarnings("unused")
    public static final String CENSUS_EDIT = "census/{id}/edit";

    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_LIST = "/censusEntries";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_NEXT = "/censusEntries/next";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_PREVIOUS = "/censusEntries/prev";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_REWIND = "/censusEntries/rewind";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_FF = "/censusEntries/ff";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_NEW = "/censusEntry/new";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY = "/censusEntry";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_SHOW = "/censusEntry/{id}/show";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_DELETE = "/censusEntry/{id}/delete";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_EDIT = "censusEntry/{id}/edit";

    @SuppressWarnings({"unused"})
    public static final String BIRTH_CERTIFICATE_LIST = "/birthCertificates";
    @SuppressWarnings({"unused"})
    public static final String BIRTH_CERTIFICATE_NEXT = "/birthCertificates/next";
    @SuppressWarnings({"unused"})
    public static final String BIRTH_CERTIFICATE_PREVIOUS = "/birthCertificates/prev";
    @SuppressWarnings({"unused"})
    public static final String BIRTH_CERTIFICATE_REWIND = "/birthCertificates/rewind";
    @SuppressWarnings({"unused"})
    public static final String BIRTH_CERTIFICATE_FF = "/birthCertificates/ff";
    @SuppressWarnings({"unused"})
    public static final String BIRTH_CERTIFICATE_NEW = "/birthCertificate/new";
    @SuppressWarnings({"unused"})
    public static final String BIRTH_CERTIFICATE = "/birthCertificate";
    @SuppressWarnings({"unused"})
    public static final String BIRTH_CERTIFICATE_SHOW = "/birthCertificate/{id}/show";
    @SuppressWarnings({"unused"})
    public static final String BIRTH_CERTIFICATE_DELETE = "/birthCertificate/{id}/delete";
    @SuppressWarnings({"unused"})
    public static final String BIRTH_CERTIFICATE_EDIT = "birthCertificate/{id}/edit";

    @SuppressWarnings({"unused"})
    public static final String DEATH_CERTIFICATE_LIST = "/deathCertificates";
    @SuppressWarnings({"unused"})
    public static final String DEATH_CERTIFICATE_NEXT = "/deathCertificates/next";
    @SuppressWarnings({"unused"})
    public static final String DEATH_CERTIFICATE_PREVIOUS = "/deathCertificates/prev";
    @SuppressWarnings({"unused"})
    public static final String DEATH_CERTIFICATE_REWIND = "/deathCertificates/rewind";
    @SuppressWarnings({"unused"})
    public static final String DEATH_CERTIFICATE_FF = "/deathCertificates/ff";
    @SuppressWarnings({"unused"})
    public static final String DEATH_CERTIFICATE_NEW = "/deathCertificate/new";
    @SuppressWarnings({"unused"})
    public static final String DEATH_CERTIFICATE = "/deathCertificate";
    @SuppressWarnings({"unused"})
    public static final String DEATH_CERTIFICATE_SHOW = "/deathCertificate/{id}/show";
    @SuppressWarnings({"unused"})
    public static final String DEATH_CERTIFICATE_DELETE = "/deathCertificate/{id}/delete";
    @SuppressWarnings({"unused"})
    public static final String DEATH_CERTIFICATE_EDIT = "deathCertificate/{id}/edit";

    @SuppressWarnings({"unused"})
    public static final String MARRIAGE_CERTIFICATE_LIST = "/marriageCertificates";
    @SuppressWarnings({"unused"})
    public static final String MARRIAGE_CERTIFICATE_NEXT = "/marriageCertificates/next";
    @SuppressWarnings({"unused"})
    public static final String MARRIAGE_CERTIFICATE_PREVIOUS = "/marriageCertificates/prev";
    @SuppressWarnings({"unused"})
    public static final String MARRIAGE_CERTIFICATE_REWIND = "/marriageCertificates/rewind";
    @SuppressWarnings({"unused"})
    public static final String MARRIAGE_CERTIFICATE_FF = "/marriageCertificates/ff";
    @SuppressWarnings({"unused"})
    public static final String MARRIAGE_CERTIFICATE_NEW = "/marriageCertificate/new";
    @SuppressWarnings({"unused"})
    public static final String MARRIAGE_CERTIFICATE = "/marriageCertificate";
    @SuppressWarnings({"unused"})
    public static final String MARRIAGE_CERTIFICATE_SHOW = "/marriageCertificate/{id}/show";
    @SuppressWarnings({"unused"})
    public static final String MARRIAGE_CERTIFICATE_DELETE = "/marriageCertificate/{id}/delete";
    @SuppressWarnings({"unused"})
    public static final String MARRIAGE_CERTIFICATE_EDIT = "marriageCertificate/{id}/edit";

    @SuppressWarnings({"unused"})
    public static final String DIVORCE_CERTIFICATE_LIST = "/divorceCertificates";
    @SuppressWarnings({"unused"})
    public static final String DIVORCE_CERTIFICATE_NEXT = "/divorceCertificates/next";
    @SuppressWarnings({"unused"})
    public static final String DIVORCE_CERTIFICATE_PREVIOUS = "/divorceCertificates/prev";
    @SuppressWarnings({"unused"})
    public static final String DIVORCE_CERTIFICATE_REWIND = "/divorceCertificates/rewind";
    @SuppressWarnings({"unused"})
    public static final String DIVORCE_CERTIFICATE_FF = "/divorceCertificates/ff";
    @SuppressWarnings({"unused"})
    public static final String DIVORCE_CERTIFICATE_NEW = "/divorceCertificate/new";
    @SuppressWarnings({"unused"})
    public static final String DIVORCE_CERTIFICATE = "/divorceCertificate";
    @SuppressWarnings({"unused"})
    public static final String DIVORCE_CERTIFICATE_SHOW = "/divorceCertificate/{id}/show";
    @SuppressWarnings({"unused"})
    public static final String DIVORCE_CERTIFICATE_DELETE = "/divorceCertificate/{id}/delete";
    @SuppressWarnings({"unused"})
    public static final String DIVORCE_CERTIFICATE_EDIT = "divorceCertificate/{id}/edit";
}
