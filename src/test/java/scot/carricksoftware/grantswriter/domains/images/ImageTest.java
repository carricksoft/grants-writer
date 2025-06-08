/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 09:54. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.images;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

class ImageTest {
    private Image image;

    @BeforeEach
    void setUp() {
        image = new Image();
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

}