/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 11:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.images;

import org.springframework.data.repository.PagingAndSortingRepository;
import scot.carricksoftware.grants.domains.images.PersonImage;

@SuppressWarnings("unused")
public interface PersonImageRepository extends PagingAndSortingRepository<PersonImage, Long> {

}
