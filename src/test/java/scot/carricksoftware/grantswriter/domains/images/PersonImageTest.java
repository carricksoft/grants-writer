/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 09:54. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.images;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

class PersonImageTest {

    private PersonImage image;

    @BeforeEach
    void setUp() {
        image = new PersonImage();
    }

    @Test
    public void getIdTest() {
        assertNull(image.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        image.setId(id);
        assertEquals(id, image.getId());
    }

    @Test
    public void getCaptionTest() {
        assertNull(image.getCaption());
    }

    @Test
    public void setCaptionTest() {
        String caption = GetRandomString();
        image.setCaption(caption);
        assertEquals(caption, image.getCaption());
    }

    @Test
    public void getHeightTest() {
        assertNull(image.getHeight());
    }

    @Test
    public void setHeightTest() {
        String height = GetRandomString();
        image.setHeight(height);
        assertEquals(height, image.getHeight());
    }

    @Test
    public void getWidthTest() {
        assertNull(image.getWidth());
    }

    @Test
    public void setWidthTest() {
        String width = GetRandomString();
        image.setWidth(width);
        assertEquals(width, image.getWidth());
    }

    @Test
    public void getImageTest() {
        assertNull(image.getImage());
    }

    @Test
    public void setImageTest() {
        Image theImage = new Image();
        image.setImage(theImage);
        assertEquals(theImage, image.getImage());
    }

    @Test
    public void getOrderTest() {
        assertNull(image.getOrder());
    }

    @Test
    public void setOrderTest() {
        String order = GetRandomString();
        image.setOrder(order);
        assertEquals(order, image.getOrder());
    }

    @Test
    public void getLevelTest() {
        assertNull(image.getLevel());
    }

    @Test
    public void setLevelTest() {
        String level = GetRandomString();
        image.setLevel(level);
        assertEquals(level, image.getLevel());
    }

    @Test
    public void getPersonTest() {
        assertNull(image.getPerson());
    }

    @Test
    public void setPersonTest() {
        Person person = GetRandomPerson();
        image.setPerson(person);
        assertEquals(person, image.getPerson());
    }

}