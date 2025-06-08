/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.enums.certificates;

public enum CertificateType {

    @SuppressWarnings("unused") EXTRACT("Extract");

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings({"unused", "SameParameterValue"})
    CertificateType(String label) {
        this.label = label;
    }
}
