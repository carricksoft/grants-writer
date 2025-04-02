package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.services.places.countries.CountryServiceImpl;
import scot.carricksoftware.grants.services.places.places.PlaceServiceImpl;
import scot.carricksoftware.grants.services.places.regions.RegionServiceImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DataLoadPlacesTest {

    private DataLoadPlaces dataLoadPlaces;


    @Mock
    private CountryServiceImpl countryServiceMock;

    @Mock
    private RegionServiceImpl regionServiceMock;

    @Mock
    private PlaceServiceImpl placeServiceMock;

    @BeforeEach
    public void setUp() {
        dataLoadPlaces = new DataLoadPlaces(countryServiceMock, regionServiceMock, placeServiceMock);
    }

    @Test
    public void scotlandIsCreatedTest() {
        ArgumentCaptor<Country> captor = ArgumentCaptor.forClass(Country.class);
        dataLoadPlaces.load();
        verify(countryServiceMock, atLeast(2)).save(captor.capture());
        assertTrue(captor.getAllValues().stream().anyMatch(country -> country.getName().equals("Scotland")));
    }

    @Test
    public void englandIsCreatedTest() {
        ArgumentCaptor<Country> captor = ArgumentCaptor.forClass(Country.class);
        dataLoadPlaces.load();
        verify(countryServiceMock, atLeast(2)).save(captor.capture());
        assertTrue(captor.getAllValues().stream().anyMatch(country -> country.getName().equals("England")));
    }

    @Test
    public void invernessIsCorrectlyCreatedTest() {
        ArgumentCaptor<Region> captor = ArgumentCaptor.forClass(Region.class);
        dataLoadPlaces.load();
        verify(regionServiceMock, atLeast(2)).save(captor.capture());
        assertTrue(captor.getAllValues().stream().anyMatch(region -> region.getName().equals("Inverness")
                && region.getCountry().getName().equals("Scotland")));
    }

    @Test
    public void midlothianIsCreatedTest() {
        ArgumentCaptor<Region> captor = ArgumentCaptor.forClass(Region.class);
        dataLoadPlaces.load();
        verify(regionServiceMock, atLeast(2)).save(captor.capture());
        assertTrue(captor.getAllValues().stream().anyMatch(region -> region.getName().equals("Midlothian")
                && region.getCountry().getName().equals("Scotland")));
    }

    @Test
    public void bellFieldParkIsCreatedTest() {
        ArgumentCaptor<Place> captor = ArgumentCaptor.forClass(Place.class);
        dataLoadPlaces.load();
        verify(placeServiceMock, atLeast(2)).save(captor.capture());
        assertTrue(captor.getAllValues().stream().anyMatch(place -> place.getName().equals("5 Bellfield Park")
                && place.getRegion().getName().equals("Inverness")));
    }

    @Test
    public void wilsonAvenueIsCreatedTest() {
        ArgumentCaptor<Place> captor = ArgumentCaptor.forClass(Place.class);
        dataLoadPlaces.load();
        verify(placeServiceMock, atLeast(2)).save(captor.capture());
        assertTrue(captor.getAllValues().stream().anyMatch(place -> place.getName().equals("2 Wilson Avenue")
                && place.getRegion().getName().equals("Midlothian")));
    }


}