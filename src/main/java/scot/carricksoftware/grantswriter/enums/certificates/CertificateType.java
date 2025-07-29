/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.enums.certificates;

public enum CertificateType {

    EXTRACT("Extract"),
    COPY("Copy");

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings({"unused", "SameParameterValue"})
    CertificateType(String label) {
        this.label = label;
    }
}
