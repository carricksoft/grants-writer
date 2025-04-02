/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:05. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.images;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class ImageCommandTest {

    private ImageCommand imageCommand;

    @BeforeEach
    void setUp() {
        imageCommand = new ImageCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(imageCommand.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        imageCommand.setId(id);
        assertEquals(id, imageCommand.getId());
    }


}