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
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.AppendixPartWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.AppendixPartWriterImpl;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.headers.AppendixPartHeader;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppendixPartWriterTest {

    private AppendixPartWriter appendixPartWriter;

    @Mock
    private AppendixPartHeader appendixPartHeaderMock;
    @Mock
    private CombinedService combinedServiceMock;

    @Mock
    private CombinedContentList combinedContentListMock;

    @Mock
    private SentenceCombinedList sentenceCombinedListMock;

    private final List<Combined> combinedList = new ArrayList<>();

    private Combined combined;

    @BeforeEach
    void setUp() {
        appendixPartWriter = new AppendixPartWriterImpl(
                appendixPartHeaderMock,
                combinedServiceMock,
                sentenceCombinedListMock);
        combined = new CombinedImpl();
        when(combinedServiceMock.getAppendixContent()).thenReturn(combinedContentListMock);
    }

    @Test
    void thePartHeaderIsWrittenTest() {
        combined.setContentType("text");
        combinedList.add(combined);
        when(combinedContentListMock.getList()).thenReturn(combinedList);

        appendixPartWriter.write();
        verify(appendixPartHeaderMock).write();
    }
}