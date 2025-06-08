/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:50. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.people;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import scot.carricksoftware.grantswriter.BaseEntity;

@Entity
public class Person extends BaseEntity {

    @Column(name = "`first_name`")
    private String firstName;

    @Column(name = "`last_name`")
    String lastName;

    @Column(name = "`recorded_year_of_birth`")
    String recordedYearOfBirth;

    @Column(name = "`certified_year_of_birth`")
    String certifiedYearOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @SuppressWarnings("unused")
    public String getRecordedYearOfBirth() {
        return recordedYearOfBirth;
    }

    @SuppressWarnings("unused")
    public void setRecordedYearOfBirth(String recordedYearOfBirth) {
        this.recordedYearOfBirth = recordedYearOfBirth;
    }

    @SuppressWarnings("unused")
    public String getCertifiedYearOfBirth() {
        return certifiedYearOfBirth;
    }

    @SuppressWarnings("unused")
    public void setCertifiedYearOfBirth(String certifiedYearOfBirth) {
        this.certifiedYearOfBirth = certifiedYearOfBirth;
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
