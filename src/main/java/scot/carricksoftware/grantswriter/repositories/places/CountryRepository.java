/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.places;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.places.Country;

@SuppressWarnings("unused")
@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {


}
