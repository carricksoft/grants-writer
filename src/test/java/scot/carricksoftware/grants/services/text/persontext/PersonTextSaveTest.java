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
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.commands.text.PersonTextCommandImpl;
import scot.carricksoftware.grants.converters.text.persontext.PersonTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.persontext.PersonTextConverterImpl;
import scot.carricksoftware.grants.domains.text.PersonText;
import scot.carricksoftware.grants.repositories.text.PersonTextRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomPersonText;


@ExtendWith(MockitoExtension.class)
public class PersonTextSaveTest {

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


    @Test
    public void saveTest() {
        PersonText personText = new PersonText();

        when(personTextRepositoryMock.save(personText)).thenReturn(personText);

        assertEquals(personText, personTextService.save(personText));
    }

    @Test
    public void savePersonTextCommandTest() {
        PersonText personText = GetRandomPersonText();
        PersonTextCommand personTextCommand = new PersonTextCommandImpl();
        when(personTextCommandConverterImplMock.convert(personTextCommand)).thenReturn(personText);
        when(personTextRepositoryMock.save(personText)).thenReturn(personText);
        when(personTextConverterImplMock.convert((personText))).thenReturn(personTextCommand);

        assertEquals(personTextCommand, personTextService.savePersonTextCommand(personTextCommand));
    }


}