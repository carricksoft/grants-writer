/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.headers.PlacesPartHeader;


@Component
public class PlacesPartWriterImpl implements PlacesPartWriter {

    private static final Logger logger = LogManager.getLogger(PlacesPartWriterImpl.class);

    private final PlacesPartHeader placesPartHeader;

    public PlacesPartWriterImpl(PlacesPartHeader placesPartHeader) {
        this.placesPartHeader = placesPartHeader;
    }


    @Override
    public void write() {
        logger.debug("PlacesPartsImpl::write()");
        placesPartHeader.write();
    }
}
