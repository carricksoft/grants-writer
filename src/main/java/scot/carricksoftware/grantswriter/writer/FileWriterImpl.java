/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class FileWriterImpl implements FileWriter {

    private static final Logger logger = LogManager.getLogger(FileWriterImpl.class);

    private OutputStream os = null;

    public void init(String fileName) throws IOException {
        logger.debug("FileWriterImpl::init");
        os = new FileOutputStream(fileName);
    }

    @Override
    public void close() throws IOException {
        logger.debug("FileWriterImpl::close");
        os.close();
    }

    @Override
    public void writeLine(String line) {
        logger.debug("FileWriterImpl::writeLine");
        try {
            os.write(line.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


