/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.AppendixPartWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.PeoplePartWriter;

@Component
public class PartsWriterImpl implements PartsWriter {

    private static final Logger logger = LogManager.getLogger(PartsWriterImpl.class);

    private final PeoplePartWriter peoplePartWriter;
    private final AppendixPartWriter appendixPartWriter;

    public PartsWriterImpl(PeoplePartWriter peoplePartWriter, AppendixPartWriter appendixPartWriter) {
        this.peoplePartWriter = peoplePartWriter;
        this.appendixPartWriter = appendixPartWriter;
    }

    @Override
    public void write() {
        logger.info("WritePartsImpl.write()");
        peoplePartWriter.write();
        appendixPartWriter.write();
    }
}
