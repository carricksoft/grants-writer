/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.data.DMY;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringToDMYConverterTest {

    private StringToDMYConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new StringToDMYConverterImpl();
    }

    @Test
    void testConvert() {
        String testString = "25/01/1953";
        DMY dmy = converter.convert(testString);
        assertEquals("25", dmy.getDay());
        assertEquals("01", dmy.getMonth());
        assertEquals("1953", dmy.getYear());
    }


}
