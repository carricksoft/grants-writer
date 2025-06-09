/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.people;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import scot.carricksoftware.grantswriter.BaseEntity;

@Entity
public class Person extends BaseEntity {

    @Column(name = "`last_name`")
    private String lastName;

    @Column(name = "`first_name`")
    private String firstName;

    @Column(name = "`certified_year_of_birth`")
    private String certifiedYearOfBirth;

    @Column(name = "`recorded_year_of_birth`")
    private String recordedYearOfBirth;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCertifiedYearOfBirth() {
        return certifiedYearOfBirth;
    }

    public void setCertifiedYearOfBirth(String certifiedYearOfBirth) {
        this.certifiedYearOfBirth = certifiedYearOfBirth;
    }

    public String getRecordedYearOfBirth() {
        return recordedYearOfBirth;
    }

    public void setRecordedYearOfBirth(String recordedYearOfBirth) {
        this.recordedYearOfBirth = recordedYearOfBirth;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.lastName);
        builder.append(", ");
        builder.append(this.firstName);
        builder.append(", ");
        if (certifiedYearOfBirth != null) {
            builder.append(certifiedYearOfBirth);
            builder.append(" ");
        } else {
            builder.append("(");
            builder.append(recordedYearOfBirth);
            builder.append(")");
            builder.append(" ");
        }
        builder.append("-");

        return builder.toString();
    }
}

