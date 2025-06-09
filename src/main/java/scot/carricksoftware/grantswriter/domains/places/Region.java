/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter.domains.places;


import jakarta.persistence.*;
import scot.carricksoftware.grantswriter.BaseEntity;

@Entity
public class Region extends BaseEntity {

    @Column(name = "`name`")
    private String name;

    @ManyToOne
    @JoinColumn(name = "`country_id`")
    private Country country;

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
