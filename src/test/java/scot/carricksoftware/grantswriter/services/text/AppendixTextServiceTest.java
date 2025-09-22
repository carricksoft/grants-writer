/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.text;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.text.AppendixText;
import scot.carricksoftware.grantswriter.repositories.text.AppendixTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AppendixTextServiceTest {

    private AppendixTextService appendixTextService;

    @Mock
    private AppendixTextRepository appendixTextRepositoryMock;


    @BeforeEach
    void setUp() {
        appendixTextService = new AppendixTextServiceImpl(appendixTextRepositoryMock);
    }

    @Test
    void testFindAllTest() {
        List<AppendixText> appendixTextList = new ArrayList<>();
        appendixTextList.add(new AppendixText());
        when(appendixTextRepositoryMock.findAll()).thenReturn(appendixTextList);
        assertEquals(appendixTextList, appendixTextService.findAll());
    }

}