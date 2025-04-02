/*
 * Copyright (c)  07 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@Component
public class ButtonConstants {
    private ButtonConstants() {
        // to stop checkstyle complaining
    }

    public static final String BACK = "<";
    public static final String DELETE = "Delete";
    public static final String EDIT = "Edit";
    public static final String NEW = "New ";//Note the space at the end
    public static final String HOME = "Home ";
    public static final String REWIND = "<<";
    public static final String END = ">>";
    public static final String FORWARD = ">";

}
