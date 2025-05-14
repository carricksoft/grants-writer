/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

public interface LatexWriter {
    @SuppressWarnings("unused")
    boolean open(String fileName);

    boolean isOpen();

    void close();
}
