/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.images;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import scot.carricksoftware.grantswriter.BaseEntity;

@MappedSuperclass
public class BaseImage extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "`image_id`")
    private Image image;

    @Column(name = "`level`")
    private String level;

    @Column(name = "`order`")
    private String order;

    @Column(name = "`caption`")
    private String caption;

    @Column(name = "`height`")
    private String height;

    @Column(name = "`width`")
    private String width;


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

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

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }
}
