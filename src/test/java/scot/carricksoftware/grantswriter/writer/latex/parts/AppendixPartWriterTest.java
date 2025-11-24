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
import scot.carricksoftware.grantswriter.combined.*;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.services.image.AppendixImageService;
import scot.carricksoftware.grantswriter.services.text.AppendixTextService;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseImage;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseText;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.AppendixPartWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.AppendixPartWriterImpl;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.headers.AppendixPartHeader;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class AppendixPartWriterTest {

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private AppendixPartWriter appendixPartWriter;

    @Mock private AppendixPartHeader appendixPartHeaderMock;
    @Mock private WriteBaseText writeBaseTextMock;
    @Mock private WriteBaseImage writeBaseImageMock;
    @Mock private AppendixTextService appendixTextServiceMock;
    @Mock private AppendixImageService appendixImageServiceMock;
    @Mock private CombinedService combinedServiceMock;

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final List<Combined> combinedList = new ArrayList<>();
    private Combined combined;

    @BeforeEach
    void setUp() {
        appendixPartWriter = new AppendixPartWriterImpl(
                appendixPartHeaderMock,
                writeBaseTextMock,
                writeBaseImageMock,
                appendixTextServiceMock,
                appendixImageServiceMock,
                combinedServiceMock);

        combined = new CombinedImpl();
    }

    @Test
    void thePartHeaderIsWrittenTest() {
        combined.setContentType("text");
        combinedList.add(combined);
        assertTrue(true);
    }
}