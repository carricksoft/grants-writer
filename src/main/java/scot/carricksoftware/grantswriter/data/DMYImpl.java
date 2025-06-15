/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;


import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;

import java.time.LocalDate;

@Component
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

        checkDay(dmy, length2(split[0]));
        checkMonth(dmy, length2(split[1]));
        checkYear(dmy,length4(split[2]));

        return dmy;
    }

    private void checkDay(DMY dmy, String s) {
        try {
            int num = Integer.parseInt(s);
            if (num < 1 || num > 31) {
                dmy.setDay(null);
            } else {
                dmy.setDay(s);
            }
        } catch (Exception e) {
            dmy.setDay(null);
        }
    }

    private void checkMonth(DMY dmy, String s) {
        try {
            int num = Integer.parseInt(s);
            if (num < 1 || num > 12) {
                dmy.setMonth(null);
            } else {
                dmy.setMonth(s);
            }
        } catch (Exception e) {
            dmy.setDay(null);
        }
    }

    private void checkYear(DMY dmy, String s) {
        try {
            int num = Integer.parseInt(s);
            if (num < 1500 || num > 2030) {
                dmy.setYear(null);
            } else {
                dmy.setYear(s);
            }
        } catch (Exception e) {
            dmy.setDay(null);
        }
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

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    private final String spaces = "    ";

    private String length2(String string) {
        return (string.trim() + spaces).substring(0, 2);
    }

    private String length4(String string) {
        return (string.trim() + spaces).substring(0, 4);
    }


    @Override
    public void setDay(String day) {
        this.day = day;
    }


    @Override
    public void setMonth(String month) {
        this.month = month;
    }


    @Override
    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public int compareTo(@NotNull DMY o) {
        LocalDate thisDate = LocalDate.parse(this.getDay() + "/" + this.getMonth() + "/" + this.getYear(), ApplicationConstants.FORMATTER);
        LocalDate oDate = LocalDate.parse(o.getDay() + "/" + o.getMonth() + "/" + o.getYear(), ApplicationConstants.FORMATTER);
        if (thisDate.isAfter(oDate)) {
            return 1;
        } if (thisDate.isEqual(oDate)) {
            return 0;
        }
        return -1;


    }
}
