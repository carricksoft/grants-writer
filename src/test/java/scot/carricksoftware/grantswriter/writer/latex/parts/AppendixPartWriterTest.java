/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.services.image.AppendixImageService;
import scot.carricksoftware.grantswriter.services.text.AppendixTextService;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseImage;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseText;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.AppendixPartWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.AppendixPartWriterImpl;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.headers.AppendixPartHeader;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class AppendixPartWriterTest {

    private AppendixPartWriter appendixPartWriter;

    @Mock private AppendixPartHeader appendixPartHeaderMock;
    @Mock private CombinedService combinedServiceMock;
    @Mock private WriteBaseText writeBaseTextMock;
    @Mock private WriteBaseImage writeBaseImageMock;
    @Mock private AppendixTextService appendixTextServiceMock;
    @Mock private AppendixImageService appendixImageServiceMock;

    @BeforeEach
    void setUp() {
        appendixPartWriter = new AppendixPartWriterImpl(
                appendixPartHeaderMock,
                combinedServiceMock,
                writeBaseTextMock,
                writeBaseImageMock,
                appendixTextServiceMock,
                appendixImageServiceMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(appendixPartWriter);
    }
}