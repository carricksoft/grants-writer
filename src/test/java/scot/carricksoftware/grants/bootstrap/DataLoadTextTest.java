package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.people.PersonServiceImpl;
import scot.carricksoftware.grants.services.places.places.PlaceServiceImpl;
import scot.carricksoftware.grants.services.text.documenttext.DocumentTextServiceImpl;
import scot.carricksoftware.grants.services.text.persontext.PersonTextServiceImpl;
import scot.carricksoftware.grants.services.text.placetext.PlaceTextServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
public class DataLoadTextTest {

    private DataLoadTexts dataLoadTexts;

    @Mock
    private DocumentTextServiceImpl documentTextServiceMock;

    @Mock
    private PersonTextServiceImpl personTextServiceMock;

    @Mock
    private PlaceTextServiceImpl placeTextServiceMock;

    @Mock
    private PersonServiceImpl personServiceMock;

    @Mock
    private PlaceServiceImpl placeServiceMock;

    @BeforeEach
    public void setUp() {
        dataLoadTexts = new DataLoadTexts(documentTextServiceMock,
                personTextServiceMock,
                placeTextServiceMock,
                personServiceMock,
                placeServiceMock);
    }

    @Test
    public void documentTextIsCreatedTest() {
        ArgumentCaptor<DocumentTextCommand> captor = ArgumentCaptor.forClass(DocumentTextCommand.class);
        dataLoadTexts.load();
        verify(documentTextServiceMock).saveDocumentTextCommand(captor.capture());
    }

    @Test
    public void personTextIsCreatedTest() {
        ArgumentCaptor<PersonTextCommand> captor = ArgumentCaptor.forClass(PersonTextCommand.class);
        Person person = GetRandomPerson();
        when(personServiceMock.findById(1L)).thenReturn(person);

        dataLoadTexts.load();

        verify(personTextServiceMock).savePersonTextCommand(captor.capture());
        assertEquals(person, captor.getValue().getPerson());
    }

    @Test
    public void placeTextIsCreatedTest() {
        ArgumentCaptor<PlaceTextCommand> captor = ArgumentCaptor.forClass(PlaceTextCommand.class);
        Place place = GetRandomPlace();
        when(placeServiceMock.findById(1L)).thenReturn(place);

        dataLoadTexts.load();

        verify(placeTextServiceMock).savePlaceTextCommand(captor.capture());
        assertEquals(place, captor.getValue().getPlace());
    }

}