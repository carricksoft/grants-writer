/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import java.io.PrintWriter;

public class LatexWriterImpl implements LatexWriter {

    private PrintWriter latexFile;

    private boolean isOpen = false;


    @Override
    public boolean open(String fileName) {
        try {
            latexFile = new PrintWriter(fileName);
            isOpen = true;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public void close() {
        if (isOpen) {
            latexFile.close();
            isOpen = false;
        }

    }


}
