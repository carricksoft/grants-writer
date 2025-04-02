/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 10:07. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.certificates;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.people.Person;

@Entity
public class DeathCertificate extends BaseEntity {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person deceased;

    public Person getDeceased() {
        return deceased;
    }

    public void setDeceased(Person deceased) {
        this.deceased = deceased;
    }
}
