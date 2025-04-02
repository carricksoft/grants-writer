/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 13:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.documenttext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.commands.text.DocumentTextCommandImpl;
import scot.carricksoftware.grants.domains.text.DocumentText;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class DocumentTextCommandConverterTest {

    private DocumentTextCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DocumentTextCommandConverterImpl();
    }

    @Test
    void covertTest() {
        Long Id = GetRandomLong();
        DocumentTextCommand source = new DocumentTextCommandImpl();

        source.setId(Id);

        DocumentText target = converter.convert(source);

        assertNotNull(target);
        assertEquals(Id, target.getId());
    }
}