/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.PeoplePart;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.PeoplePartHeader;

@Component
public class WritePartsImpl implements WriteParts {

    private static final Logger logger = LogManager.getLogger(WritePartsImpl.class);

    private final PeoplePart peoplePart;

    private final PeoplePartHeader peoplePartHeader;

    public WritePartsImpl(PeoplePart peoplePart, PeoplePartHeader peoplePartHeader) {
        this.peoplePart = peoplePart;
        this.peoplePartHeader = peoplePartHeader;
    }

    @Override
    public void write() {
        logger.info("WritePartsImpl.write()");
        peoplePartHeader.write();
        peoplePart.write();
    }
}
