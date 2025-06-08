/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter.domains.places;


import jakarta.persistence.*;
import scot.carricksoftware.grantswriter.BaseEntity;
import scot.carricksoftware.grantswriter.domains.census.Census;
import scot.carricksoftware.grantswriter.domains.images.PlaceImage;
import scot.carricksoftware.grantswriter.domains.text.PlaceText;



import java.util.ArrayList;
import java.util.List;

@Entity
public class Place extends BaseEntity {

    @Column(name = "`name`")
    private String name;

    @ManyToOne
    @JoinColumn(name = "`region_id`")
    private Region region;

    @SuppressWarnings("unused")
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Census> censuses = new ArrayList<>();

    @SuppressWarnings("unused")
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlaceImage> placeImages = new ArrayList<>();

    @SuppressWarnings("unused")
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlaceText> placeTexts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Census> getCensuses() {
        return censuses;
    }

    public void setCensuses(List<Census> censuses) {
        this.censuses = censuses;
    }

    public List<PlaceImage> getPlaceImages() {
        return placeImages;
    }

    public void setPlaceImages(List<PlaceImage> placeImages) {
        this.placeImages = placeImages;
    }

    public List<PlaceText> getPlaceTexts() {
        return placeTexts;
    }

    public void setPlaceTexts(List<PlaceText> placeTexts) {
        this.placeTexts = placeTexts;
    }

    @Override
    public String toString() {
        return name +
                ", " + region.getName() +
                ", " + region.getCountry().getName();
    }
}
