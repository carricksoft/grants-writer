/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.helpers.LatexDivision;
import scot.carricksoftware.grantswriter.writer.FileWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class LatexDivisionHeaderTest {

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private LatexDivisionHeader header;

    @Mock
    private FileWriter fileWriterMock;
    @Mock
    private LatexDivision latexDivisionMock;

    @BeforeEach
    void setUp() {
        header = new LatexDivisionHeaderImpl(fileWriterMock, latexDivisionMock);
    }

    @Test
    void dummyTest() {
        assertTrue(true);
    }

 }
