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
import scot.carricksoftware.grantswriter.domains.images.PersonImage;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.text.PersonText;
import scot.carricksoftware.grantswriter.repositories.images.PersonImageRepository;
import scot.carricksoftware.grantswriter.repositories.text.PersonTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class CombinedPersonServiceTest {

    private CombinedPersonService service;

    @Mock
    PersonTextRepository personTextRepositoryMock;

    @Mock
    PersonImageRepository personImageRepositoryMock;

    private List<PersonText> personTextList;
    private List<PersonImage> personImageList;
    private final String order = GetRandomString();
    private final Long Id = GetRandomLong();
    private final Person person = GetRandomPerson();
    private final PersonText personText = new PersonText();
    private final PersonImage personImage = new PersonImage();

    @BeforeEach
    void setUp() {
        service = new CombinedPersonServiceImpl(personTextRepositoryMock, personImageRepositoryMock);
        personTextList = new ArrayList<>();
        personImageList = new ArrayList<>();

    }

    @Test
    void personTextsAreCorrectlyAddedTest() {
        personText.setOrder(order);
        personText.setId(Id);
        personTextList.add(personText);
        when(personTextRepositoryMock.findAllByPerson(person)).thenReturn(personTextList);
        CombinedContentList combinedContentList = service.getPersonContent(person);

        Combined combined = combinedContentList.getList().get(0);
        assertEquals("text", combined.getContentType());
        assertEquals(order, combined.getOrder());
        assertEquals(Id, combined.getContentId());
    }

    @Test
    void personImagesAreCorrectlyAddedTest() {
        personImage.setOrder(order);
        personImage.setId(Id);
        personImageList.add(personImage);
        when(personImageRepositoryMock.findAllByPerson(person)).thenReturn(personImageList);
        CombinedContentList combinedContentList = service.getPersonContent(person);

        Combined combined = combinedContentList.getList().get(0);
        assertEquals("image", combined.getContentType());
        assertEquals(order, combined.getOrder());
        assertEquals(Id, combined.getContentId());
    }


}