/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:53. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.divorcecertificates;

import scot.carricksoftware.grants.domains.people.Person;

public interface DivorceCertificateCommand {


    Long getId();

    void setId(Long id);

    Person getFirstParty();

    void setFirstParty(Person firstParty);

    Person getSecondParty();

    void setSecondParty(Person secondParty);


}
