/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.certificates;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

import java.util.Optional;

@SuppressWarnings("unused")
@Repository
public interface MarriageCertificateRepository extends PagingAndSortingRepository<MarriageCertificate, Long> {

    @SuppressWarnings("unused")
    MarriageCertificate save(MarriageCertificate marriageCertificate);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    Optional<MarriageCertificate> findById(Long id);

    @SuppressWarnings("unused")
    Iterable<MarriageCertificate> findAll();

}
