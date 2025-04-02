/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 12:33. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.text.placetext;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.domains.text.PlaceText;

import java.util.List;


@Service
public interface PlaceTextService {

    @SuppressWarnings("unused")
    PlaceText findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    PlaceText save(PlaceText placeText);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<PlaceText> getPagedPlaceTexts(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    PlaceTextCommand savePlaceTextCommand(PlaceTextCommand placeTextCommand);

    @SuppressWarnings("unused")
    List<PlaceText> findAll();
}
