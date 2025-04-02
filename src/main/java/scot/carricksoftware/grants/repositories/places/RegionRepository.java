/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:48. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.places;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.places.Region;

import java.util.Optional;

@SuppressWarnings("unused")
@Repository
public interface RegionRepository extends PagingAndSortingRepository<Region, Long> {

    @SuppressWarnings("unused")
    Region save(Region region);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    Optional<Region> findById(Long id);

    @SuppressWarnings("unused")
    Iterable<Region> findAll();
}
