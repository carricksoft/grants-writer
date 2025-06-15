/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

public interface DMY {

    String toString();

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    DMY parse(String string);

    @SuppressWarnings({"unused", "SameReturnValue"})
    String getDay();

    @SuppressWarnings({"unused", "SameReturnValue"})
    String getMonth();

    @SuppressWarnings({"unused", "SameReturnValue"})
    String getYear();

}
