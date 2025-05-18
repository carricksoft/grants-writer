/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TexWriterImpl implements TexWriter {

    private final FileWriter fileWriter;

    public TexWriterImpl(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void write(String filename) throws IOException {
        fileWriter.init(filename);
        fileWriter.writeLine("Archie");
        fileWriter.close();
    }
}
