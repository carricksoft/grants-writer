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
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.text.PersonText;
import scot.carricksoftware.grantswriter.repositories.text.PersonTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class CombinedServiceTest {

    private CombinedService service;

    @Mock
    PersonTextRepository personTextRepositoryMock;

    private final Long personTextId = GetRandomLong();
    private final String personTextOrder = GetRandomString();
    private final List<PersonText> personTextList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        service = new CombinedServiceImpl(personTextRepositoryMock);
    }

    @Test
    void personTextsAreAddedTest() {
        createPersonTextList();
        when(personTextRepositoryMock.findAllByPerson(any(Person.class))).thenReturn(personTextList);
        CombinedContentList contentList = service.getPersonContent(GetRandomPerson());
        assertEquals(personTextId, contentList.getList().get(0).getContentId());
        assertEquals("text", contentList.getList().get(0).getContentType());
        assertEquals(personTextOrder, contentList.getList().get(0).getOrder());
    }

    private void createPersonTextList() {
        PersonText personText = new PersonText();
        personText.setId(personTextId);
        personText.setOrder(personTextOrder);
        personTextList.add(personText);
    }


}