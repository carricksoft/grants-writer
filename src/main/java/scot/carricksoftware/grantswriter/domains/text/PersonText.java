/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:20. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.text;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import scot.carricksoftware.grantswriter.domains.people.Person;

@Entity
@Table(name="`person_text`")
public class PersonText extends BaseText {

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
