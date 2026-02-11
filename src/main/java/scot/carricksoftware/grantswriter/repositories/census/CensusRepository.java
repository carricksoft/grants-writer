/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.census;

import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.census.Census;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.repositories.ReadOnlyRepository;

import java.util.List;

@Repository
public interface CensusRepository extends ReadOnlyRepository<Census, Long> {
    List<Census> findAllByPlace(Place place);
}
