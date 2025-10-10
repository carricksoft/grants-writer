/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

public interface LatexBlock {


    void begin(String blockName, String options);
    void end(String blockName);
}
