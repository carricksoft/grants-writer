/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.deathcertificate;


import scot.carricksoftware.grantswriter.domains.certificates.deathcertificate.DeathCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;

import java.util.List;

public interface DeathCertificateService {

    List<DeathCertificate> findAllByDeceased(Person person);

    List<DeathCertificate> findAllByInformant(Person person);

    List<DeathCertificate> findAllBySpouse(Person person);

    List<DeathCertificate> findAllByWhereDied(Place place);

}
