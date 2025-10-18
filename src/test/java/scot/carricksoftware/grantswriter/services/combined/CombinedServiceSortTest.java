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
import scot.carricksoftware.grantswriter.domains.images.PersonImage;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.text.PersonText;
import scot.carricksoftware.grantswriter.repositories.images.PersonImageRepository;
import scot.carricksoftware.grantswriter.repositories.text.PersonTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class CombinedServiceSortTest {

    private CombinedService service;

    @Mock
    PersonTextRepository personTextRepositoryMock;

    @Mock
    PersonImageRepository personImageRepositoryMock;

    private List<PersonText> personTextList;
    private List<PersonImage> personImageList;
    private final Long Id = GetRandomLong();
    private final Person person = GetRandomPerson();
    private final PersonText personText = new PersonText();
    private final PersonImage personImage = new PersonImage();

    @BeforeEach
    void setUp() {
        service = new CombinedServiceImpl(personTextRepositoryMock, personImageRepositoryMock);
        personTextList = new ArrayList<>();
        personImageList = new ArrayList<>();
    }

    @Test
    void sortingWorksTest() {
        String highOrder = "99";
        personText.setOrder(highOrder);
        personText.setId(Id);
        personTextList.add(personText);
        when(personTextRepositoryMock.findAllByPerson(person)).thenReturn(personTextList);

        String lowOrder = "1";
        personImage.setOrder(lowOrder);
        personImage.setId(Id);
        personImageList.add(personImage);
        when(personImageRepositoryMock.findAllByPerson(person)).thenReturn(personImageList);
        CombinedContentList combinedContentList = service.getPersonContent(person);

        assertEquals(lowOrder, combinedContentList.getList().get(0).getOrder());
        assertEquals(highOrder, combinedContentList.getList().get(1).getOrder());
    }


}