/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 16:14. All rights reserved.
 *
 */

package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.services.images.personimage.PersonImageService;
import scot.carricksoftware.grants.services.images.placeimage.PlaceImageService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class DataLoadImagesTest {

    private DataLoadImages dataLoadImages;

    @Mock
    private ImageService imageServiceMock;

    @Mock
    private PersonImageService personImageServiceMock;

    @Mock
    private PlaceImageService placeImageServiceMock;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private PersonService personServiceMock;

    @BeforeEach
    void setUp() {
        dataLoadImages = new DataLoadImages(imageServiceMock,
                personImageServiceMock,
                placeImageServiceMock,
                personServiceMock,
                placeServiceMock);
    }

    @Test
    public void anImageIsCreatedTest() {
        ArgumentCaptor<ImageCommand> captor = ArgumentCaptor.forClass(ImageCommand.class);
        dataLoadImages.load();
        verify(imageServiceMock).saveImageCommand(captor.capture());
    }

    @Test
    public void aPersonImageIsCreatedTest() {
        ArgumentCaptor<PersonImageCommand> captor = ArgumentCaptor.forClass(PersonImageCommand.class);
        Person person = GetRandomPerson();

        when(personServiceMock.findById(1L)).thenReturn(person);
        dataLoadImages.load();

        verify(personImageServiceMock).savePersonImageCommand(captor.capture());
        assertEquals(person, captor.getValue().getPerson());
    }

    @Test
    public void aPlaceImageIsCreatedTest() {
        ArgumentCaptor<PlaceImageCommand> captor = ArgumentCaptor.forClass(PlaceImageCommand.class);
        Place place = GetRandomPlace();
        when(placeServiceMock.findById(1L)).thenReturn(place);

        dataLoadImages.load();

        verify(placeImageServiceMock).savePlaceImageCommand(captor.capture());
        assertEquals(place, captor.getValue().getPlace());
    }
}