/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class PeoplePartsImpl implements PeopleParts {

    private static final Logger logger = LogManager.getLogger(PeoplePartsImpl.class);

    @Override
    public void write() {
        logger.info("PeoplePartsImpl.write()");
    }
}
