/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.birthcertificate;


import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;

import java.util.List;

public interface BirthCertificateService {

    List<BirthCertificate> findAllByNewBorn(Person person);

    List<BirthCertificate> findAllByFather(Person person);

    List<BirthCertificate> findAllByMother(Person person);

    List<BirthCertificate> findAllByInformant(Person person);

    List<BirthCertificate> findAllByWhereBorn(Place place);

    List<BirthCertificate> findAllByWhereRegistered(String string);
}
