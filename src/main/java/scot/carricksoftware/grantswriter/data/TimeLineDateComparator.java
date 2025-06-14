/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import java.util.Comparator;

public class TimeLineDateComparator implements Comparator<String> {

    @SuppressWarnings("ComparatorMethodParameterNotUsed")
    @Override
    public int compare(String a, String b) {
        String[] aParts = a.split("/");
        String[] bParts = b.split("/");

        if (Integer.parseInt(aParts[2]) > Integer.parseInt(bParts[2])) {
            return 1;
        }

        if (Integer.parseInt(aParts[1]) > Integer.parseInt(bParts[1])) {
            return 1;
        }

        if (Integer.parseInt(aParts[0]) > Integer.parseInt(bParts[0])) {
            return 1;
        }

        return 0;
    }
}
