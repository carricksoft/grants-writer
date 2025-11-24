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
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.combined.CombinedImpl;
import scot.carricksoftware.grantswriter.domains.images.DocumentImage;
import scot.carricksoftware.grantswriter.domains.text.DocumentText;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.services.image.DocumentImageService;
import scot.carricksoftware.grantswriter.services.text.DocumentTextService;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseImage;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseText;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DocumentPartWriterTest {

    @SuppressWarnings({"unused"})
    private DocumentPartWriter documentPartWriter;

    @Mock private WriteBaseText writeBaseTextMock;
    @Mock private WriteBaseImage writeBaseImageMock;
    @Mock private DocumentTextService documentTextServiceMock;
    @Mock private DocumentImageService documentImageServiceMock;
    @Mock private CombinedService combinedServiceMock;
    @Mock private CombinedContentList combinedContentListMock;


    @SuppressWarnings("unused")
    private final List<Combined> combinedList = new ArrayList<>();
    @SuppressWarnings({"unused"})
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
        when(combinedServiceMock.getDocumentContent()).thenReturn(combinedContentListMock);
    }

    @Test
    void imagesAreCorrectlyRoutedTest() {
        combined.setContentType("image");
        combinedList.add(combined);
        DocumentImage documentImage = new DocumentImage();
        when(combinedContentListMock.getList()).thenReturn(combinedList);
        when(documentImageServiceMock.findById(any())).thenReturn(documentImage);

        documentPartWriter.write();
        verify(writeBaseImageMock).write(documentImage);
    }

    @Test
    void textsAreCorrectlyRoutedTest() {
        combined.setContentType("text");
        combinedList.add(combined);
        DocumentText documentText = new DocumentText();
        when(combinedContentListMock.getList()).thenReturn(combinedList);
        when(documentTextServiceMock.findById(any())).thenReturn(documentText);

        documentPartWriter.write();
        verify(writeBaseTextMock).write(documentText);
    }



}