package scot.carricksoftware.grants.domains.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;

class CountryTest {
    private Country country;


    @BeforeEach
    public void setUp() {
        country = new Country();
    }

    @Test
    public void getIdTest() {
        assertNull(country.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        country.setId(id);
        assertEquals(id, country.getId());
    }

    @Test
    public void getNameTest() {
        assertNull(country.getName());
    }

    @Test
    public void setLastNameTest() {
        String name = GetRandomString();
        country.setName(name);
        assertEquals(name, country.getName());
    }

    @Test
    public void getRegionsTest() {
        assertTrue(country.getRegions().isEmpty());
    }

    @Test
    public void setRegionsTest() {
        List<Region> regions = new ArrayList<>();
        regions.add(GetRandomRegion());
        country.setRegions(regions);
        assertEquals(regions, country.getRegions());
    }


}