/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.certificates;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.certificates.MarriageCertificate;

@SuppressWarnings("unused")
@Repository
public interface MarriageCertificateRepository extends PagingAndSortingRepository<MarriageCertificate, Long> {


}
