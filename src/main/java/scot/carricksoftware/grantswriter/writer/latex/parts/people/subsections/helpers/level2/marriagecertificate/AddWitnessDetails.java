/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate;

import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;

import java.util.List;
import java.util.TreeMap;

public interface AddWitnessDetails {
    void addWitnessDetails(TreeMap<DMY, List<String>> timeLine, MarriageCertificate marriageCertificate);
}
