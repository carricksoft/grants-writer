/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

public interface LatexDivisionHeader {

    void write(Integer level, String title);
    @SuppressWarnings("unused")
    void write(String levelString, String title);
}
