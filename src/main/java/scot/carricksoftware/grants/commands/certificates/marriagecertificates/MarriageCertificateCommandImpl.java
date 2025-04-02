/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:52. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.marriagecertificates;

import scot.carricksoftware.grants.domains.people.Person;

public class MarriageCertificateCommandImpl implements MarriageCertificateCommand {

    Long Id;

    Person bride;

    Person groom;

    @Override
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


    @Override
    public Person getBride() {
        return bride;
    }


    @Override
    public void setBride(Person bride) {
        this.bride = bride;
    }


    @Override
    public Person getGroom() {
        return groom;
    }


    @Override
    public void setGroom(Person groom) {
        this.groom = groom;
    }
}
