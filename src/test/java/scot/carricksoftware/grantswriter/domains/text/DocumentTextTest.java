/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:28. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;


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