/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:50. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.images;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import scot.carricksoftware.grantswriter.BaseEntity;

@Entity
@Table(name="`image`")
public class Image extends BaseEntity {

    @Column(name = "`name`")
    private String name;

    @Column(name= "`file_name`")
    private String fileName;

    @Lob
    @Column(name = "`imageData`")
    private String imageData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
