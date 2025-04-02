/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 11:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.images;

import org.springframework.data.repository.PagingAndSortingRepository;
import scot.carricksoftware.grants.domains.images.PersonImage;

import java.util.Optional;

public interface PersonImageRepository extends PagingAndSortingRepository<PersonImage, Long> {

    PersonImage save(PersonImage image);

    long count();

    void deleteById(Long id);

    Optional<PersonImage> findById(Long id);

    Iterable<PersonImage> findAll();
}
