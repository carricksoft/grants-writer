/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 12:33. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.image;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.domains.images.Image;

import java.util.List;


@Service
public interface ImageService {

    @SuppressWarnings("unused")
    Image findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
Image save(Image image);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<Image> getPagedImages(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    ImageCommand saveImageCommand(ImageCommand imageCommand);

    @SuppressWarnings("unused")
    List<Image> findAll();
}
