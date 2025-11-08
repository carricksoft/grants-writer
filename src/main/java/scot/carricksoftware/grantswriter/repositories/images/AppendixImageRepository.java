/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 11:02. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.images;


import scot.carricksoftware.grantswriter.domains.images.AppendixImage;
import scot.carricksoftware.grantswriter.domains.images.PersonImage;
import scot.carricksoftware.grantswriter.repositories.ReadOnlyRepository;


public interface AppendixImageRepository extends ReadOnlyRepository<PersonImage, Long> {
    Iterable<AppendixImage> findAll();

}
