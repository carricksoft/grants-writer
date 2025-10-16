/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import scot.carricksoftware.grantswriter.repositories.text.PersonTextRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CombinedServiceTest {

    private CombinedService service;

    @Mock
    PersonTextRepository personTextRepositoryMock;

    @BeforeEach
    void setUp() {
        service = new CombinedServiceImpl(personTextRepositoryMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(service);
    }



}