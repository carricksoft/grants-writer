/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 14:31. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.text;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class DocumentTextCommandValidatorTest {

    private DocumentTextCommandValidator validator;

    @BeforeEach
    void setUp() {
        validator = new DocumentTextCommandValidator();
    }

    @Test
    void existenceTest() {
        assertNotNull(validator);
    }
}