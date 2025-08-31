/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.divorcecertificate.helpers;

import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.domains.certificates.divorcecertificate.DivorceCertificate;

import java.util.List;
import java.util.TreeMap;

public interface AddDivorceDetails {
    void addDivorceDetails(TreeMap<DMY, List<String>> timeLine, DivorceCertificate divorceCertificate);
}
