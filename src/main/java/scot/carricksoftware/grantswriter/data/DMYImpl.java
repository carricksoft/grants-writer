/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

public class DMYImpl implements DMY
{


    @SuppressWarnings("unused")
    String day;
    @SuppressWarnings("unused")
    String month;
    @SuppressWarnings("unused")
    String year;

    @Override
    public DMY  parse(String string) {
        return new DMYImpl();
    }

    @Override
    public String getDay() {
        return "";
    }

    @Override
    public String getMonth() {
        return "";
    }

    @Override
    public String getYear() {
        return "";
    }

    public String toString() {
        return null;
    }

    private final String spaces = "    ";

    @SuppressWarnings({"unused", "SameReturnValue"})
    private String length2(String string){
        return (string + spaces).substring(0, 1);
    }

    @SuppressWarnings({"unused", "SameReturnValue"})
    private String length4(String string){
        return (string + spaces).substring(0, 3);
    }


}
