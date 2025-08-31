/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;


public interface DMY extends Comparable<DMY> {

    String toString();

    void parse(String string);

    String getDay();

    String getMonth();

    String getYear();

    void setDay(String day);

    void setMonth(String  month);

    void setYear(String year) ;


}
