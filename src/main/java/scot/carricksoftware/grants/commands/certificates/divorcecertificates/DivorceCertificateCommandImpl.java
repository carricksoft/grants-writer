/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:53. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.divorcecertificates;

import scot.carricksoftware.grants.domains.people.Person;

public class DivorceCertificateCommandImpl implements DivorceCertificateCommand {

    Long Id;

    private Person firstParty;

    private Person secondParty;

    public Person getFirstParty() {
        return firstParty;
    }

    public void setFirstParty(Person firstParty) {
        this.firstParty = firstParty;
    }

    public Person getSecondParty() {
        return secondParty;
    }

    public void setSecondParty(Person secondParty) {
        this.secondParty = secondParty;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


}
