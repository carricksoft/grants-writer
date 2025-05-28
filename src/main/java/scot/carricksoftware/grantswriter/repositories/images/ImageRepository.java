/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 11:02. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.images;

import scot.carricksoftware.grantswriter.domains.images.Image;
import scot.carricksoftware.grantswriter.repositories.ReadOnlyRepository;

@SuppressWarnings("unused")
public interface ImageRepository extends ReadOnlyRepository<Image, Long> {

}
