/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 11:02. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.images;

import org.springframework.data.repository.PagingAndSortingRepository;
import scot.carricksoftware.grantswriter.domains.images.PersonImage;

@SuppressWarnings("unused")
public interface PersonImageRepository extends PagingAndSortingRepository<PersonImage, Long> {

}
