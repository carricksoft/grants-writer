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
import scot.carricksoftware.grantswriter.combined.Combined;
import scot.carricksoftware.grantswriter.combined.CombinedImpl;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.services.image.DocumentImageService;
import scot.carricksoftware.grantswriter.services.text.DocumentTextService;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseImage;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseText;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class DocumentPartWriterTest {

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private DocumentPartWriter documentPartWriter;

    @Mock private WriteBaseText writeBaseTextMock;
    @Mock private WriteBaseImage writeBaseImageMock;
    @Mock private DocumentTextService documentTextServiceMock;
    @Mock private DocumentImageService documentImageServiceMock;
    @Mock private CombinedService combinedServiceMock;

    @SuppressWarnings("unused")
    private final List<Combined> combinedList = new ArrayList<>();
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private Combined combined;

    @BeforeEach
    void setUp() {
        documentPartWriter = new DocumentPartWriterImpl(
                writeBaseTextMock,
                writeBaseImageMock,
                documentTextServiceMock,
                documentImageServiceMock,
                combinedServiceMock);

        combined = new CombinedImpl();
    }

   @Test
    void dummyTest() {
        assertTrue(true);
   }


}