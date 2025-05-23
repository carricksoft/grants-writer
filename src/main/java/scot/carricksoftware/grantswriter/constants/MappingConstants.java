/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.constants;

import org.springframework.stereotype.Component;

@Component
public class MappingConstants {

    private MappingConstants() {
        // to stop checkstyle complaining
    }

    public static final String FILES = "/files";

    public static final String TEX = "/tex";

    public static final String BUILD_PDF = "/pdf";

    public static final String PRINT = "/print";


}
