/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 12:33. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.placeimage;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.domains.images.PlaceImage;

import java.util.List;


@Service
public interface PlaceImageService {

    @SuppressWarnings("unused")
    PlaceImage findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    PlaceImage save(PlaceImage peronImage);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<PlaceImage> getPagedPlaceImages(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    PlaceImageCommand savePlaceImageCommand(PlaceImageCommand peronImageCommand);

    @SuppressWarnings("unused")
    List<PlaceImage> findAll();
}
