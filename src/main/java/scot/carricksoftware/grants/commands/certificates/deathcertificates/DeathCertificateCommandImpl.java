/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:52. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.deathcertificates;

import scot.carricksoftware.grants.domains.people.Person;

public class DeathCertificateCommandImpl implements DeathCertificateCommand {

    Long Id;

    Person deceased;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public Person getDeceased() {
        return deceased;
    }

    @Override
    public void setDeceased(Person deceased) {
        this.deceased = deceased;
    }

}
