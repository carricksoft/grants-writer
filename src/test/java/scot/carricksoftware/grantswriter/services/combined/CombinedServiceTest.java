/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.combined.CombinedContentListImpl;
import scot.carricksoftware.grantswriter.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class CombinedServiceTest {

    private CombinedService combinedService;

    @Mock
    private CombinedPersonService combinedPersonServiceMock;

    @BeforeEach
    void setUp() {
        combinedService = new CombinedServiceImpl(combinedPersonServiceMock);
    }

    @Test
    void testGetPersonContent() {
        Person person = GetRandomPerson();
        CombinedContentList result = new CombinedContentListImpl();
        when(combinedPersonServiceMock.getPersonContent(person)).thenReturn(result);

        assertEquals(result,combinedService.getPersonContent(person));
    }


}