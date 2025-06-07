/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.services.people.PersonService;
import scot.carricksoftware.grantswriter.writer.latex.sections.PersonSection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class PeoplePartTest {

    private PeoplePart peoplePart;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PersonSection personSectionMock;

    @SuppressWarnings("EmptyMethod")
    @BeforeEach
    void setUp() {
        peoplePart = new PeoplePartImpl(personServiceMock, personSectionMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(peoplePart);
    }
}