/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.services.text.PersonTextService;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexDivisionHeader;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class PersonSectionContentsWriterTest {

    private PersonSectionContentsWriter writer;

    @Mock private PersonTextService personTextServiceMock;
    @Mock private CombinedService combinedServiceMock;
    @Mock private FileWriter fileWriterMock;
    @Mock private LatexDivisionHeader latexDivisionHeaderMock;

    @BeforeEach
    void setUp() {
        writer = new PersonSectionContentsWriterImpl(
                personTextServiceMock,
                combinedServiceMock,
                fileWriterMock,
                latexDivisionHeaderMock
                );
    }

    @Test
    void constructorTest() {
        assertNotNull(writer);
    }
}