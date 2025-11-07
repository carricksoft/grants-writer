/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.text;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import scot.carricksoftware.grantswriter.BaseEntity;

@Entity
public class AppendixText extends BaseEntity {

    @Column(name = "`level`")
    private String level;

    @Column(name = "`order`")
    private String order;

    @Column(name = "`heading`")
    private String heading;

    @Column(name = "`content`")
    @Lob
    private String content;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
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
