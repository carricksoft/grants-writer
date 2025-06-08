/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.enums.general;

public enum YesNo {

    @SuppressWarnings("unused") YES("Yes"),
    NO ("No");

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings("unused")
    YesNo(String label) {
        this.label = label;
    }
}
