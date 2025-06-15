/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

class DMYSetterAndGetterTest {

    private DMY dmy;
    @BeforeEach

    void setUp() {
        dmy = new DMYImpl();
    }

   @Test
    void constructorTest() {
        assertNotNull(dmy);
   }

   @Test
    void getDayTest() {
        assertNull(dmy.getDay());
   }

    @Test
    void setDayTest() {
        String day = GetRandomString();
        dmy.setDay(day);
        assertEquals(day, dmy.getDay());
    }

    @Test
    void getMonthTest() {
        assertNull(dmy.getMonth());
    }

    @Test
    void setMonthTest() {
        String month = GetRandomString();
        dmy.setMonth(month);
        assertEquals(month, dmy.getMonth());
    }

    @Test
    void getYearTest() {
        assertNull(dmy.getYear());
    }

    @Test
    void setYearTest() {
        String year = GetRandomString();
        dmy.setMonth(year);
        assertEquals(year, dmy.getMonth());
    }

}