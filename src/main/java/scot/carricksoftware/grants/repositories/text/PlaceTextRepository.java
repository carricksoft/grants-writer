/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.text;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.text.PlaceText;

import java.util.Optional;


@SuppressWarnings("unused")
@Repository
public interface PlaceTextRepository extends PagingAndSortingRepository<PlaceText, Long> {

    @SuppressWarnings("unused")
    PlaceText save(PlaceText placeText);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    Optional<PlaceText> findById(Long id);

    @SuppressWarnings("unused")
    Iterable<PlaceText> findAll();
}
