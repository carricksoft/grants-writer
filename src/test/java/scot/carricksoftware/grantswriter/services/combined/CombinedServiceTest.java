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
import scot.carricksoftware.grantswriter.combined.Combined;
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.text.PersonText;
import scot.carricksoftware.grantswriter.repositories.text.PersonTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class CombinedServiceTest {

    private CombinedService service;

    @Mock
    PersonTextRepository personTextRepositoryMock;

    private List<PersonText> personTextList;
    private final String order = GetRandomString();
    private final Long personId = GetRandomLong();
    private final Person person = GetRandomPerson();
    private final PersonText personText = new PersonText();

    @BeforeEach
    void setUp() {
        service = new CombinedServiceImpl(personTextRepositoryMock);
        personTextList = new ArrayList<>();

    }

    @Test
    void personTextsAreCorrectlyAddedTest() {
        personText.setOrder(order);
        personTextList.add(personText);
        when(personTextRepositoryMock.findAllByPerson(person)).thenReturn(personTextList);
        CombinedContentList combinedContentList = service.getPersonContent(person);

        Combined combined = combinedContentList.getList().get(0);
        assertEquals("text", combined.getContentType());
        assertEquals(order, combined.getOrder());
    }


}