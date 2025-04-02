/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.certificates;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.people.Person;

@Entity
public class DivorceCertificate extends BaseEntity {


    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "first_party_id")
    private Person firstParty;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "second_party_id")
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
}
