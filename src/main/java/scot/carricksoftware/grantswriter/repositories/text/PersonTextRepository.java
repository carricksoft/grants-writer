/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.text;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.text.PersonText;

import java.util.Optional;


@SuppressWarnings("unused")
@Repository
public interface PersonTextRepository extends PagingAndSortingRepository<PersonText, Long> {

    @SuppressWarnings("unused")
    PersonText save(PersonText personText);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    Optional<PersonText> findById(Long id);

    @SuppressWarnings("unused")
    Iterable<PersonText> findAll();
}
