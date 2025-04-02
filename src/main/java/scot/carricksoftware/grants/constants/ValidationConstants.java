/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:54. All rights reserved.
 *
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;


@SuppressWarnings("unused")
@Component
public class ValidationConstants {
    private ValidationConstants() {
        // to stop checkstyle complaining
    }


    public static final String NAME_IS_TOO_SHORT = "Name must be at least " + ApplicationConstants.MINIMUM_NAME_LENGTH + " characters long.";
    public static final String NAME_IS_TOO_LONG = "Name must be no more than " + ApplicationConstants.MAXIMUM_NAME_LENGTH + " characters long.";
    public static final String DATE_IS_NULL = "Date must exist.";
    public static final String DATE_IN_FUTURE = "Date should not be in the future.";
    public static final String CENSUS_IS_NULL = "The census should be specified";
    public static final String CENSUS_NAME_IS_NULL = "Either Person or Untracked Person must be given";
    public static final String CENSUS_NAME_IS_NOT_NULL = "Both Person and Untracked Person cannot be given";

    public static final String PERSON_IS_NULL = "The person cannot be null.";
    public static final String PLACE_IS_NULL = "The place cannot be null.";

    public static final String BRIDE_IS_NULL = "The bride cannot be null.";
    public static final String GROOM_IS_NULL = "The groom cannot be null.";
    public static final String SAME_BRIDE_AND_GROOM = "The bride and groom cannot be the same person.";

    public static final String FIRST_PARTY_IS_NULL = "The first party cannot be null.";
    public static final String SECOND_PARTY_IS_NULL = "The second party cannot be null.";
    public static final String SAME_TWO_PARTIES = "The two parties cannot be the same person.";


}
