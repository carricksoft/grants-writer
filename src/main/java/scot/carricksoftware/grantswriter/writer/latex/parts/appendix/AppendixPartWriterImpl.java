/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.appendix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.headers.AppendixPartHeader;

@Component
public class AppendixPartWriterImpl implements AppendixPartWriter {

    private static final Logger logger = LogManager.getLogger(AppendixPartWriterImpl.class);

    private final AppendixPartHeader appendixPartHeader;

    public AppendixPartWriterImpl(AppendixPartHeader appendixPartHeader) {
        this.appendixPartHeader = appendixPartHeader;
    }

    @Override
    public void write() {
        logger.info("AppendixPartsImpl::write()");
        appendixPartHeader.write();
    }
}
