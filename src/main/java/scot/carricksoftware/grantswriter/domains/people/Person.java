/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:50. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.people;

import jakarta.persistence.Entity;
import scot.carricksoftware.grantswriter.BaseEntity;

@Entity
public class Person extends BaseEntity {

    String firstName;
    String lastName;

    @SuppressWarnings("unused")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @SuppressWarnings("unused")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
