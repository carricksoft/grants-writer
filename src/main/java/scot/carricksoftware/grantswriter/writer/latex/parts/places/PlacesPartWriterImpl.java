/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.services.place.PlaceService;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.headers.PlacesPartHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.sections.PlaceSection;

import java.util.List;


@Component
public class PlacesPartWriterImpl implements PlacesPartWriter {

    private static final Logger logger = LogManager.getLogger(PlacesPartWriterImpl.class);

    private final PlacesPartHeader placesPartHeader;
    private final PlaceService placeService;
    private final PlaceSection placeSection;

    public PlacesPartWriterImpl(PlacesPartHeader placesPartHeader,
                                PlaceService placeService,
                                PlaceSection placeSection) {
        this.placesPartHeader = placesPartHeader;
        this.placeService = placeService;
        this.placeSection = placeSection;
    }


    @Override
    public void write() {
        logger.debug("PlacesPartsImpl::write()");
        placesPartHeader.write();

        List<Place> places = placeService.findAll();
        for (Place place : places) {
            placeSection.write(place);
        }
    }
}
