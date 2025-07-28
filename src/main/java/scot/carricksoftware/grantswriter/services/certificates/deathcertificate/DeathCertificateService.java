/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.deathcertificate;


import scot.carricksoftware.grantswriter.domains.certificates.deathcertificate.DeathCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;

import java.util.List;

public interface DeathCertificateService {

    @SuppressWarnings("unused")
    List<DeathCertificate> findAllByDeceased(Person person);

    @SuppressWarnings("unused")
    List<DeathCertificate> findAllByInformant(Person person);

    @SuppressWarnings("unused")
    List<DeathCertificate> findAllBySpouse(Person person);
}
