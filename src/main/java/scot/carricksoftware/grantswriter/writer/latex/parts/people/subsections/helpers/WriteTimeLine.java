/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import scot.carricksoftware.grantswriter.data.DMY;

import java.util.List;
import java.util.TreeMap;

public interface WriteTimeLine {
    void write (TreeMap<DMY, List<String>> map);
}
