/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:48. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.places;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.places.Region;

@SuppressWarnings("unused")
@Repository
public interface RegionRepository extends PagingAndSortingRepository<Region, Long> {


}
