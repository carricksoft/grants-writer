/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DMYImplTest {

    private DMY dmy;
    @BeforeEach

    void setUp() {
        dmy = new DMYImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(dmy);
    }
}