/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.certificates.birthcertificate;

import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.repositories.ReadOnlyRepository;

@Repository
public interface BirthCertificateRepository extends ReadOnlyRepository<BirthCertificate, Long> {

    Iterable<BirthCertificate> findAllByNewBorn(Person person);

    Iterable<BirthCertificate> findAllByFather(Person person);

    Iterable<BirthCertificate> findAllByMother(Person person);

    Iterable<BirthCertificate> findAllByInformant(Person person);

    Iterable<BirthCertificate> findAllByWhereBorn(Place place);

    Iterable<BirthCertificate> findAllByWhereRegistered(String string);
}
