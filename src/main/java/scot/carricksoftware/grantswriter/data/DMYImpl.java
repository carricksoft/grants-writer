/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

public class DMYImpl implements DMY {


    @SuppressWarnings("unused")
    String day;
    @SuppressWarnings("unused")
    String month;
    @SuppressWarnings("unused")
    String year;

    @Override
    public DMY parse(String string) {
        DMY dmy = new DMYImpl();
        String[] split = string.split("/");
        day = length2(split[0]);

        month = length2(split[1]);

        year = length4(split[2]);
        return dmy;
    }

    @Override
    public String getDay() {
        return day;
    }

    @Override
    public String getMonth() {
        return month;
    }

    @Override
    public String getYear() {
        return year;
    }

    public String toString() {
        return day + "/" + month + "/" + year;
    }

    private final String spaces = "    ";

    private String length2(String string) {
        return (string + spaces).substring(0, 1);
    }

    private String length4(String string) {
        return (string + spaces).substring(0, 3);
    }


}
