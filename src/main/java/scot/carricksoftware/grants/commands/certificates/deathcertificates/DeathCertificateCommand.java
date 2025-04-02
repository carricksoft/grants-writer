/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:51. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.deathcertificates;

import scot.carricksoftware.grants.domains.people.Person;

public interface DeathCertificateCommand {


    Long getId();

    void setId(Long id);

    Person getDeceased();

    void setDeceased(Person deceased);
}
