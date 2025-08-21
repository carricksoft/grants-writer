/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.certificates.marriagecertificate;

import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.ReadOnlyRepository;

@SuppressWarnings("unused")
@Repository
public interface MarriageCertificateRepository extends ReadOnlyRepository<MarriageCertificate, Long> {

    Iterable<MarriageCertificate> findAllByBride(Person person);

    Iterable<MarriageCertificate> findAllByGroom(Person person);

    Iterable<MarriageCertificate> findAllByFirstWitness(Person person);

    Iterable<MarriageCertificate> findAllBySecondWitness(Person person);
}
