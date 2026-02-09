/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;



@Component
public class PlacesPartWriterImpl implements PlacesPartWriter {

    private static final Logger logger = LogManager.getLogger(PlacesPartWriterImpl.class);

    @Override
    public void write() {
        logger.debug("PlacesPartsImpl::write()");
    }
}
