/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import scot.carricksoftware.grantswriter.repositories.people.PersonRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PersonServiceTest {

    private PersonService service;

    @Mock
    private PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        service = new PersonServiceImpl(personRepository);
    }

    @Test
    void constructorTest() {
        assertNotNull(service);
    }
}