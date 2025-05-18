/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import java.io.IOException;

public interface FileWriter {

    void init(String texFilename) throws IOException;
    void close() throws IOException;

    void writeLine(String line);
}
