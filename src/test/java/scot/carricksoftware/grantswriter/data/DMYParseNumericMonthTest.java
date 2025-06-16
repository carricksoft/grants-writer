/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DMYParseNumericMonthTest {

    private DMY dmy;

    @BeforeEach
    void setUp() {
        dmy = new DMYImpl();
    }

    @Test
    void tooLowMonthTest() {
        String input = "25/00/1953";
        dmy.setMonth("99");
        dmy.parse(input);
        assertNull(dmy.getMonth());
    }

    @Test
    void lowMonthTest() {
        String input = "25/01/1953";
        dmy.setMonth("99");
        dmy.parse(input);
        assertEquals("01", dmy.getMonth());
    }

    @Test
    void highMonthTest() {
        String input = "25/12/1953";
        dmy.setMonth("99");
        dmy.parse(input);
        assertEquals("12", dmy.getMonth());
    }

    @Test
    void tooHighMonthTest() {
        String input = "25/13/1953";
        dmy.setMonth("99");
        dmy.parse(input);
        assertNull(dmy.getMonth());
    }

    @Test
    void invalidMonthTest() {
        String input = "25/zz/1953";
        dmy.setMonth("99");
        dmy.parse(input);
        assertNull(dmy.getMonth());
    }


}