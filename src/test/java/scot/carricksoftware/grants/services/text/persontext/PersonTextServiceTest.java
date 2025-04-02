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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.text.persontext.PersonTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.persontext.PersonTextConverterImpl;
import scot.carricksoftware.grants.domains.text.PersonText;
import scot.carricksoftware.grants.repositories.text.PersonTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomPersonText;


@ExtendWith(MockitoExtension.class)
public class PersonTextServiceTest {

    PersonTextService personTextService;

    @Mock
    PersonTextRepository personTextRepositoryMock;

    @Mock
    PersonTextConverterImpl personTextConverterImplMock;

    @Mock
    PersonTextCommandConverterImpl personTextCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        personTextService = new PersonTextServiceImpl(personTextRepositoryMock,
                personTextConverterImplMock,
                personTextCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @Mock
    Page<PersonText> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        personTextService.deleteById(id);
        verify(personTextRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(personTextRepositoryMock.count()).thenReturn(result);
        assertEquals(result, personTextService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<PersonText> result = new ArrayList<>();
        PersonText personText = GetRandomPersonText();
        result.add(personText);
        when(pageMock.getContent()).thenReturn(result);
        when(personTextRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, personTextService.getPagedPersonTexts(0));
    }
    

}