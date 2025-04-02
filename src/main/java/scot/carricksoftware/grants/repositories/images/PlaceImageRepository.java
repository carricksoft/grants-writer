/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 11:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.images;

import org.springframework.data.repository.PagingAndSortingRepository;
import scot.carricksoftware.grants.domains.images.PlaceImage;

import java.util.Optional;

public interface PlaceImageRepository extends PagingAndSortingRepository<PlaceImage, Long> {

    PlaceImage save(PlaceImage image);

    long count();

    void deleteById(Long id);

    Optional<PlaceImage> findById(Long id);

    Iterable<PlaceImage> findAll();
}
