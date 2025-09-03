/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:20. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.text;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import scot.carricksoftware.grantswriter.BaseEntity;
import scot.carricksoftware.grantswriter.domains.people.Person;

@Entity
public class PersonText extends BaseEntity {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`person_id`")
    private Person person;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`level`")
    private Long level;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`order`")
    private Long order;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`heading`")
    private String heading;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`content`")
    @Lob
    private String content;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
