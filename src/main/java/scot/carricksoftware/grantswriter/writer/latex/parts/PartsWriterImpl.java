/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.PeoplePartWriter;

@Component
public class PartsWriterImpl implements PartsWriter {

    private static final Logger logger = LogManager.getLogger(PartsWriterImpl.class);

    private final PeoplePartWriter peoplePartWriter;

    public PartsWriterImpl(PeoplePartWriter peoplePartWriter) {
        this.peoplePartWriter = peoplePartWriter;
    }

    @Override
    public void write() {
        logger.info("WritePartsImpl.write()");
        peoplePartWriter.write();
    }
}
