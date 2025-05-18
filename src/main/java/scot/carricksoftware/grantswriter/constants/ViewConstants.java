/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.constants;

import org.springframework.stereotype.Component;

@Component
public class ViewConstants {

    private ViewConstants() {
        // to stop checkstyle complaining
    }

    public static final String NOT_AVAILABLE = "not-available";

    @SuppressWarnings("unused")
    public static final String FILES = "files";
    public static final String TEX = "tex";
    public static final String HOME = "index";

}
