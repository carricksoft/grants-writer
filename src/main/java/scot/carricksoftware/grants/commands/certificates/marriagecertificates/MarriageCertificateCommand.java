/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:52. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.marriagecertificates;

import scot.carricksoftware.grants.domains.people.Person;

public interface MarriageCertificateCommand {


    Long getId();

    void setId(Long id);


    Person getBride();

    void setBride(Person bride);

    Person getGroom();

    void setGroom(Person groom);
}
