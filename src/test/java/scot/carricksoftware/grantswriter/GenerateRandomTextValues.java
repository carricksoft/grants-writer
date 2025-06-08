/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter;


import scot.carricksoftware.grantswriter.domains.text.DocumentText;
import scot.carricksoftware.grantswriter.domains.text.PersonText;
import scot.carricksoftware.grantswriter.domains.text.PlaceText;

import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@SuppressWarnings("unused")

public class GenerateRandomTextValues {

    public static DocumentText GetRandomDocumentText() {
        DocumentText documentText = new DocumentText();
        documentText.setId(GetRandomLong());
        return documentText;
    }

    public static PersonText GetRandomPersonText() {
        PersonText personText = new PersonText();
        personText.setId(GetRandomLong());
        personText.setPerson(GetRandomPerson());
        return personText;
    }

    public static PlaceText GetRandomPlaceText() {
        PlaceText placeText = new PlaceText();
        placeText.setId(GetRandomLong());
        placeText.setPlace(GetRandomPlace());
        return placeText;
    }

}
