/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.document;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.writer.latex.parts.SentenceCombinedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class DocumentPartWriterTest {

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private DocumentPartWriter documentPartWriter;

    @Mock
    private CombinedService combinedServiceMock;

    @Mock
    private SentenceCombinedList sentenceCombinedListMock;

    @BeforeEach
    void setUp() {
        documentPartWriter = new DocumentPartWriterImpl(
                combinedServiceMock,
                sentenceCombinedListMock);
    }

   @Test
    void dummyTest() {
        assertTrue(true);
   }


}