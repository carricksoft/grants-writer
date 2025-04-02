/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 12:33. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.personimage;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.domains.images.PersonImage;

import java.util.List;


@Service
public interface PersonImageService {

    @SuppressWarnings("unused")
    PersonImage findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    PersonImage save(PersonImage peronImage);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<PersonImage> getPagedPersonImages(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    PersonImageCommand savePersonImageCommand(PersonImageCommand peronImageCommand);

    @SuppressWarnings("unused")
    List<PersonImage> findAll();
}
