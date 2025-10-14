/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.combined;

public enum CombinedContentType {

    TEXT("text"),
    IMAGE("image");

    public final String label;

    CombinedContentType(String label) {
        this.label = label;
    }
}
