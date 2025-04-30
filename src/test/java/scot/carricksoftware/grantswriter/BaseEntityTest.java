/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

public class BaseEntityTest {

    private BaseEntity entity;

    @BeforeEach
    public void setUp() {
        entity = new BaseEntity();
    }

    @Test
    public void getIdTest() {
        assertNull(entity.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        entity.setId(id);
        assertEquals(id, entity.getId());
    }
}