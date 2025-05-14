/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LatexWriterTest {

    private LatexWriter writer;

    @BeforeEach
    void setUp() {
        writer = new LatexWriterImpl();
    }

    @Test
    void openOutputTest() {
        assertNotNull(writer);
    }
}