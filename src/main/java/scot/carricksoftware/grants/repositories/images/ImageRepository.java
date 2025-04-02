/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 11:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.images;

import org.springframework.data.repository.PagingAndSortingRepository;
import scot.carricksoftware.grants.domains.images.Image;

import java.util.Optional;

public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {

    Image save(Image image);

    long count();

    void deleteById(Long id);

    Optional<Image> findById(Long id);

    Iterable<Image> findAll();
}
