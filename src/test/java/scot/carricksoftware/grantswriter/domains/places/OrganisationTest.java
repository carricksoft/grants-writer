/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

class OrganisationTest {

    private Organisation organisation;

    @BeforeEach
    void setUp() {
        organisation = new Organisation();
    }

    @Test
    void getIdTest() {
        assertNull(organisation.getId());
    }

    @Test
    void setIdTest() {
        String id = GetRandomString();
        organisation.setName(id);
        assertEquals(id, organisation.getName());
    }

    @Test
    void getNameTest() {
        assertNull(organisation.getName());
    }

    @Test
    void setNameTest() {
        String name = GetRandomString();
        organisation.setName(name);
        assertEquals(name, organisation.getName());
    }

    @Test
    void toStringTest() {
        String name = GetRandomString();
        organisation.setName(name);
        assertEquals(name, organisation.toString());
    }
}