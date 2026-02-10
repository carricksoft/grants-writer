/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.marriagecertificate;

import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;

import java.util.List;

public interface MarriageCertificateService {

    List<MarriageCertificate> findAllByGroom(Person person);

    List<MarriageCertificate> findAllByBride(Person person);

    List<MarriageCertificate> findAllByFirstWitness(Person person);

    List<MarriageCertificate> findAllBySecondWitness(Person person);

    List<MarriageCertificate> findAllByWhereMarried(Place place);
}
