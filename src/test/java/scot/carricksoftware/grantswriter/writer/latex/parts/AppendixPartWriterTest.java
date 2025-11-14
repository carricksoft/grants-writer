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
import scot.carricksoftware.grantswriter.domains.images.AppendixImage;
import scot.carricksoftware.grantswriter.domains.text.AppendixText;
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

import static org.mockito.ArgumentMatchers.any;
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
    private WriteBaseText writeBaseTextMock;
    @Mock
    private WriteBaseImage writeBaseImageMock;
    @Mock
    private AppendixTextService appendixTextServiceMock;
    @Mock
    private AppendixImageService appendixImageServiceMock;

    @Mock
    private CombinedContentList combinedContentListMock;

    private final List<Combined> combinedList = new ArrayList<>();

    private Combined combined;

    @BeforeEach
    void setUp() {
        appendixPartWriter = new AppendixPartWriterImpl(
                appendixPartHeaderMock,
                combinedServiceMock,
                writeBaseTextMock,
                writeBaseImageMock,
                appendixTextServiceMock,
                appendixImageServiceMock);
        combined = new CombinedImpl();
        when(combinedServiceMock.getAppendixContent()).thenReturn(combinedContentListMock);
    }

    @Test
    void imagesAreCorrectlyRoutedTest() {
        combined.setContentType("image");
        combinedList.add(combined);
        AppendixImage appendixImage = new AppendixImage();
        when(combinedContentListMock.getList()).thenReturn(combinedList);
        when(appendixImageServiceMock.findById(any())).thenReturn(appendixImage);

        appendixPartWriter.write();
        verify(writeBaseImageMock).write(appendixImage);
    }

    @Test
    void textsAreCorrectlyRoutedTest() {
        combined.setContentType("text");
        combinedList.add(combined);
        AppendixText appendixText = new AppendixText();
        when(combinedContentListMock.getList()).thenReturn(combinedList);
        when(appendixTextServiceMock.findById(any())).thenReturn(appendixText);

        appendixPartWriter.write();
        verify(writeBaseTextMock).write(appendixText);
    }

    @Test
    void thePartHeaderIsWrittenTest() {
        combined.setContentType("text");
        combinedList.add(combined);
        AppendixText appendixText = new AppendixText();
        when(combinedContentListMock.getList()).thenReturn(combinedList);
        when(appendixTextServiceMock.findById(any())).thenReturn(appendixText);

        appendixPartWriter.write();
        verify(appendixPartHeaderMock).write();
    }
}