/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToFileConverterTest {

    private StringToFileConverter converter;

    @BeforeEach
    void setUp() {
        converter = new StringToFileConverterImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(converter);
    }
}