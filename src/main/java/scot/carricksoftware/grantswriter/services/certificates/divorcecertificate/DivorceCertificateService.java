/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.divorcecertificate;


import scot.carricksoftware.grantswriter.domains.certificates.divorcecertificate.DivorceCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;

import java.util.List;

public interface DivorceCertificateService {

    @SuppressWarnings("unused")
    List<DivorceCertificate> findAllByFirstParty(Person person);

    @SuppressWarnings("unused")
    List<DivorceCertificate> findAllBySecondParty(Person person);

}
