/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:28. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class DocumentTextTest {

    private DocumentText documentText;

    @BeforeEach
    void setUp() {
        documentText = new DocumentText();
    }

    @Test
    void getIdTest() {
        Long id = GetRandomLong();
        documentText.setId(id);
        assertNotNull(documentText.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        documentText.setId(id);
        assertEquals(id, documentText.getId());
    }

}