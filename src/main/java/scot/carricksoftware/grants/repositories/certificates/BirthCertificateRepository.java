/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.certificates;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

import java.util.Optional;

@SuppressWarnings("unused")
@Repository
public interface BirthCertificateRepository extends PagingAndSortingRepository<BirthCertificate, Long> {

    @SuppressWarnings("unused")
    BirthCertificate save(BirthCertificate birthCertificate);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    Optional<BirthCertificate> findById(Long id);

    @SuppressWarnings("unused")
    Iterable<BirthCertificate> findAll();

}
