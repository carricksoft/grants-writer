/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.writer.latex.LatexSectionHeader;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonSectionHeaderTest {

    PersonSectionHeader personSectionHeader;

    @Mock
    LatexSectionHeader latexSectionHeaderMock;

    @BeforeEach
    void setUp() {
        personSectionHeader = new PersonSectionHeaderImpl(latexSectionHeaderMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(personSectionHeader);
    }
}