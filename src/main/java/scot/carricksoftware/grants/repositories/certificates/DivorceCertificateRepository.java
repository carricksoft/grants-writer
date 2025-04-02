/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.certificates;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;


import java.util.Optional;

@SuppressWarnings("unused")
@Repository
public interface DivorceCertificateRepository extends PagingAndSortingRepository<DivorceCertificate, Long> {

    @SuppressWarnings("unused")
    DivorceCertificate save(DivorceCertificate divorceCertificate);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    Optional<DivorceCertificate> findById(Long id);

    @SuppressWarnings("unused")
    Iterable<DivorceCertificate> findAll();

}
