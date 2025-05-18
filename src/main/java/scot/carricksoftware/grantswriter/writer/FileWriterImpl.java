/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class FileWriterImpl implements FileWriter {

    private static final Logger logger = LogManager.getLogger(FileWriterImpl.class);

    private PrintWriter printWriter = null;


    @Override
    public void init(String fileName) throws IOException {
        logger.debug("FileWriterImpl::init");
        printWriter = new PrintWriter(fileName);
    }

    @Override
    public void close() {
        logger.debug("FileWriterImpl::close");
        printWriter.close();
        printWriter = null;
    }

    @Override
    public void writeLine(String line) {
        logger.debug("FileWriterImpl::writeLine");
        printWriter.println(line);
    }

    @Override
    public PrintWriter getPrintWriter() {
        return printWriter;
    }


}


