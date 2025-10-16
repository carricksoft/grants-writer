/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CombinedServiceTest {

    private CombinedService service;

    @BeforeEach
    void setUp() {
        service = new CombinedServiceImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(service);
    }



}