/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import java.io.IOException;
import java.io.OutputStream;

public interface FileWriter {

    void init(String texFilename) throws IOException;
    void close();

    void writeLine(String line);

    OutputStream getOs();

}
