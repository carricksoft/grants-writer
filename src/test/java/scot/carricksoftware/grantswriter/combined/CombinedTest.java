/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.combined;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

class CombinedTest {

    private Combined combined;

    private String string;

    @BeforeEach
    void setUp() {
        combined = new CombinedImpl();
        string = GetRandomString();
    }

    @Test
    void getContentTypeTest() {
        assertNull(combined.getContentType());
    }

    @Test
    void setContentTypeTest() {
        combined.setContentType(string);
        assertEquals(string, combined.getContentType());
    }

    @Test
    void getOrderTest() {
        assertNull(combined.getContentType());
    }

    @Test
    void setOrderTest() {
        combined.setOrder(string);
        assertEquals(string, combined.getOrder());
    }

    @Test
    void getContentIdTest() {
        assertNull(combined.getContentId());
    }

    @Test
    void setContentIdTest() {
        Long aLong = GetRandomLong();
        combined.setContentId(aLong);
        assertEquals(aLong, combined.getContentId());
    }


}