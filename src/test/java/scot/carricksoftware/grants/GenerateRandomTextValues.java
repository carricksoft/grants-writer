/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.text.*;
import scot.carricksoftware.grants.domains.text.DocumentText;
import scot.carricksoftware.grants.domains.text.PersonText;
import scot.carricksoftware.grants.domains.text.PlaceText;

import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;


@SuppressWarnings("unused")
@Component
public class GenerateRandomTextValues {

    public static DocumentText GetRandomDocumentText() {
       DocumentText documentText = new DocumentText();
       documentText.setId(GetRandomLong());
       return documentText;
    }

    @SuppressWarnings("unused")
    public static DocumentTextCommand GetRandomDocumentTextCommand() {
        DocumentTextCommand documentTextCommand = new DocumentTextCommandImpl();
        documentTextCommand.setId(GetRandomLong());
        return documentTextCommand;
    }

    public static PersonText GetRandomPersonText() {
        PersonText personText = new PersonText();
        personText.setId(GetRandomLong());
        personText.setPerson(GetRandomPerson());
        return personText;
    }

    @SuppressWarnings("unused")
    public static PersonTextCommand GetRandomPersonTextCommand() {
        PersonTextCommand personTextCommand = new PersonTextCommandImpl();
        personTextCommand.setId(GetRandomLong());
        personTextCommand.setPerson(GetRandomPerson());
        return personTextCommand;
    }

    public static PlaceText GetRandomPlaceText() {
        PlaceText placeText = new PlaceText();
        placeText.setId(GetRandomLong());
        placeText.setPlace(GetRandomPlace());
        return placeText;
    }

    @SuppressWarnings("unused")
    public static PlaceTextCommand GetRandomPlaceTextCommand() {
        PlaceTextCommand placeTextCommand = new PlaceTextCommandImpl();
        placeTextCommand.setId(GetRandomLong());
        placeTextCommand.setPlace(GetRandomPlace());
        return placeTextCommand;
    }


}
