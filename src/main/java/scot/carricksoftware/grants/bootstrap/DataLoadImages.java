/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.*;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.services.images.personimage.PersonImageService;
import scot.carricksoftware.grants.services.images.placeimage.PlaceImageService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

@Component
@Profile("dev")
public class DataLoadImages {

    private static final Logger logger = LogManager.getLogger(DataLoadImages.class);


    private final ImageService imageService;
    private final PersonImageService personImageService;
    private final PlaceImageService placeImageService;
    private final PersonService personService;
    private final PlaceService placeService;


    public DataLoadImages(ImageService imageService, PersonImageService personImageService, PlaceImageService placeImageService, PersonService personService, PlaceService placeService) {
        this.imageService = imageService;
        this.personImageService = personImageService;
        this.placeImageService = placeImageService;
        this.personService = personService;
        this.placeService = placeService;
    }

    public void load() {
        logger.debug("DataLoadCensus::load");
        loadImage();
        loadPersonImage();
        loadPlaceImage();
    }

    private void loadImage() {
        logger.debug("DataLoadCensus::loadImage");
        ImageCommand imageCommand = new ImageCommandImpl();

        imageService.saveImageCommand(imageCommand);
    }

    private void loadPersonImage() {
        logger.debug("DataLoadCensus::loadPersonImage");
        PersonImageCommand imageCommand = new PersonImageCommandImpl();
        imageCommand.setPerson(personService.findById(1L));

        personImageService.savePersonImageCommand(imageCommand);
    }

    private void loadPlaceImage() {
        logger.debug("DataLoadCensus::loadPlaceImage");
        PlaceImageCommand imageCommand = new PlaceImageCommandImpl();
        imageCommand.setPlace(placeService.findById(1L));

        placeImageService.savePlaceImageCommand(imageCommand);
    }



}
