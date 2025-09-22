/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

class AppendixTextTest {
    
    private AppendixText appendixText;

    @BeforeEach
    void setUp() {
        appendixText = new AppendixText();
    }

    @Test
    void getIdTest() {
        Long id = GetRandomLong();
        appendixText.setId(id);
        assertNotNull(appendixText.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        appendixText.setId(id);
        assertEquals(id, appendixText.getId());
    }


    @Test
    void getLevelTest() {
        assertNull(appendixText.getLevel());
    }

    @Test
    void setLevelTest() {
        String level = GetRandomString();
        appendixText.setLevel(level);
        assertEquals(level, appendixText.getLevel());
    }

    @Test
    void getOrderTest() {
        assertNull(appendixText.getOrder());
    }

    @Test
    void setOrderTest() {
        String order = GetRandomString();
        appendixText.setOrder(order);
        assertEquals(order, appendixText.getOrder());
    }

    @Test
    void getHeadingTest() {
        assertNull(appendixText.getHeading());
    }

    @Test
    void setHeadingTest() {
        String heading = GetRandomString();
        appendixText.setHeading(heading);
        assertEquals(heading, appendixText.getHeading());
    }

    @Test
    void getContentTest() {
        assertNull(appendixText.getContent());
    }

    @Test
    void setContentTest() {
        String content = GetRandomString();
        appendixText.setContent(content);
        assertEquals(content, appendixText.getContent());
    }
    
}