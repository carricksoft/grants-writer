/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:54. All rights reserved.
 *
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@SuppressWarnings("unused")
@Component
public class ApplicationConstants {

    private ApplicationConstants() {
        // to stop checkstyle complaining
    }

    public static final int DEFAULT_PAGE_SIZE = 15;
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public final static String EMPTY_STRING = "";

    public static final int MINIMUM_NAME_LENGTH = 3;
    public static final int MAXIMUM_NAME_LENGTH = 40;

}
