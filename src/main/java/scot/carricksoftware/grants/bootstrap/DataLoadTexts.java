/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.text.*;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.services.text.documenttext.DocumentTextService;
import scot.carricksoftware.grants.services.text.persontext.PersonTextService;
import scot.carricksoftware.grants.services.text.placetext.PlaceTextService;

@Component
public class DataLoadTexts {

    private static final Logger logger = LogManager.getLogger(DataLoadTexts.class);

    private final DocumentTextService documentTextService;
    private final PersonTextService personTextService;
    private final PlaceTextService placeTextService;
    private final PersonService personService;
    private final PlaceService placeService;

    public DataLoadTexts(DocumentTextService documentTextService,
                         PersonTextService personTextService, PlaceTextService placeTextService,
                         PersonService personService, PlaceService placeService) {
        this.documentTextService = documentTextService;
        this.personTextService = personTextService;
        this.placeTextService = placeTextService;
        this.personService = personService;
        this.placeService = placeService;
    }

    public void load() {
        logger.debug("DataLoadPlaces::load");
        loadDocumentText();
        loadPersonText();
        loadPlaceText();
    }

    private void loadDocumentText() {
        DocumentTextCommand documentTextCommand = new DocumentTextCommandImpl();
        documentTextService.saveDocumentTextCommand(documentTextCommand);
    }

    private void loadPersonText() {
        PersonTextCommand personTextCommand = new PersonTextCommandImpl();
        personTextCommand.setPerson(personService.findById(1L));
        personTextService.savePersonTextCommand(personTextCommand);
    }

    private void loadPlaceText() {
        PlaceTextCommand placeTextCommand = new PlaceTextCommandImpl();
        placeTextCommand.setPlace(placeService.findById(1L));
        placeTextService.savePlaceTextCommand(placeTextCommand);
    }

}
