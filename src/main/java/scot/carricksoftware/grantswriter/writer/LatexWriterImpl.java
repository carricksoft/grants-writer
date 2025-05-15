/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;

@SuppressWarnings("LoggingSimilarMessage")
public class LatexWriterImpl implements LatexWriter {

    private static final Logger logger = LogManager.getLogger(LatexWriterImpl.class);

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
    public void close() {
        if (isOpen) {
            latexFile = null;
            isOpen = false;
        }
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public void print(String string) {
        try {
            latexFile.println(string);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //noinspection StringConcatenationArgumentToLogCall
            logger.debug("Printed " + string);
        }
    }

    @Override
    public void println(String string) {
        try {
            latexFile.println(string);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //noinspection StringConcatenationArgumentToLogCall
            logger.debug("Printed " + string);
        }
    }
}
