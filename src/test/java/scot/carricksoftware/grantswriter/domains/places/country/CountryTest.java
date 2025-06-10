package scot.carricksoftware.grantswriter.domains.places.country;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.places.Country;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

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


}