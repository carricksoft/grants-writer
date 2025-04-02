/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:05. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class DocumentTextCommandTest {

    private DocumentTextCommand documentTextCommand;

    @BeforeEach
    void setUp() {
        documentTextCommand = new DocumentTextCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(documentTextCommand.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        documentTextCommand.setId(id);
        assertEquals(id, documentTextCommand.getId());
    }


}