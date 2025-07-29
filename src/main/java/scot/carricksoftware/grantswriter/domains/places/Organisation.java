/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.places;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import scot.carricksoftware.grantswriter.BaseEntity;

@Entity
public class Organisation extends BaseEntity {

    @Column(name = "`name`")
    private String name;

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
