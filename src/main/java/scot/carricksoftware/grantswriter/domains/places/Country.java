/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter.domains.places;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import scot.carricksoftware.grantswriter.BaseEntity;


@Entity
public class Country extends BaseEntity {

    @Column(name = "`name`")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
