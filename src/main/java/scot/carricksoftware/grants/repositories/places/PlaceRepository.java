/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:48. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.places;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.Optional;

@SuppressWarnings("unused")
@Repository
public interface PlaceRepository extends PagingAndSortingRepository<Place, Long> {

    @SuppressWarnings("unused")
    Place save(Place place);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    Optional<Place> findById(Long id);

    @SuppressWarnings("unused")
    Iterable<Place> findAll();
}
