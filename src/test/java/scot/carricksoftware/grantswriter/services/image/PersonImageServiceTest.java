/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.image;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.images.PersonImage;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.images.PersonImageRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonImageServiceTest {

    private PersonImageService personImageService;

    @Mock
    private PersonImageRepository personImageRepositoryMock;

    @BeforeEach
    void setUp() {
        personImageService = new PersonImageServiceImpl(personImageRepositoryMock);
    }

    @Test
    void findAllByPersonTest() {
        Person person = new Person();
        List<PersonImage> personImageList = new ArrayList<>();
        personImageList.add(new PersonImage());
        when(personImageRepositoryMock.findAllByPerson(person)).thenReturn(personImageList);
        assertEquals(personImageList, personImageService.findAllByPerson(person));
    }

}