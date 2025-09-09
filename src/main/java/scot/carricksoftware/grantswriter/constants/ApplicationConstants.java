/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:54. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.constants;

import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;


@Component
public class ApplicationConstants {

    private ApplicationConstants() {
        // to stop checkstyle complaining
    }

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String DATE_TIME_FORMAT = "dd/MM/yyyy hh:mm";
    public static final String EMPTY_STRING = "";

}
