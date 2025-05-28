/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.places;

import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.places.Country;
import scot.carricksoftware.grantswriter.repositories.ReadOnlyRepository;

@SuppressWarnings("unused")
@Repository
public interface CountryRepository extends ReadOnlyRepository<Country, Long> {


}
