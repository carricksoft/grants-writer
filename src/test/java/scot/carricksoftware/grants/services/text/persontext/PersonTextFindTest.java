/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.text.persontext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.converters.text.persontext.PersonTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.persontext.PersonTextConverterImpl;
import scot.carricksoftware.grants.domains.text.PersonText;
import scot.carricksoftware.grants.repositories.text.PersonTextRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomPersonText;

@ExtendWith(MockitoExtension.class)
public class PersonTextFindTest {

    PersonTextService personTextService;

    @Mock
    PersonTextRepository personTextRepositoryMock;

    @Mock
    PersonTextConverterImpl personTextConverterMock;

    @Mock
    PersonTextCommandConverterImpl personTextCommandConverterMock;

    @BeforeEach
    public void setUp() {
        personTextService = new PersonTextServiceImpl(personTextRepositoryMock,
                personTextConverterMock,
                personTextCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<PersonText> countries = new ArrayList<>();
        countries.add(GetRandomPersonText());
        when(personTextRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, personTextService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        PersonText personText = GetRandomPersonText();
        Optional<PersonText> personTextOptional = Optional.of(personText);
        when(personTextRepositoryMock.findById(id)).thenReturn(personTextOptional);
        assertEquals(personText, personTextService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<PersonText> empty = Optional.empty();
        when(personTextRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(personTextService.findById(id));
    }

}