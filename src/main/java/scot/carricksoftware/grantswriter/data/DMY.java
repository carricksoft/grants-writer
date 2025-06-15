/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;


public interface DMY extends Comparable<DMY> {

    String toString();

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    DMY parse(String string);

    @SuppressWarnings({"unused", "SameReturnValue"})
    String getDay();

    @SuppressWarnings({"unused", "SameReturnValue"})
    String getMonth();

    @SuppressWarnings({"unused", "SameReturnValue"})
    String getYear();

    void setDay(String day);

    void setMonth(String  month);
    void setYear(String year) ;


}
