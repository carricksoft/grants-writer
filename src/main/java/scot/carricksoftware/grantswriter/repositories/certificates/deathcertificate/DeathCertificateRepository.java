/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.certificates.deathcertificate;

import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.certificates.deathcertificate.DeathCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.repositories.ReadOnlyRepository;

@Repository
public interface DeathCertificateRepository extends ReadOnlyRepository<DeathCertificate, Long> {

    Iterable<DeathCertificate> findAllByDeceased(Person person);

    Iterable<DeathCertificate> findAllByInformant(Person person);

    Iterable<DeathCertificate> findAllBySpouse(Person person);

    Iterable<DeathCertificate> findAllByWhereDied(Place place);

    Iterable<DeathCertificate> findAllByWhereRegistered(Place place);
}
