/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.converters.StringToFileConverter;
import scot.carricksoftware.grantswriter.domains.images.BaseImage;
import scot.carricksoftware.grantswriter.domains.images.Image;
import scot.carricksoftware.grantswriter.writer.FileWriter;

import static org.mockito.Mockito.*;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class WriteBaseImageTest {

    private WriteBaseImage writeBaseImage;

    @Mock
    private FileWriter fileWriterMock;

    @Mock
    private LatexBlock latexBlockMock;

    @Mock
    private StringToFileConverter stringToFileConverterMock;

    private BaseImage baseImage;
    private String imageData;
    private String fileName;

    @BeforeEach
    void setUp() {
        writeBaseImage = new WriteBaseImageImpl(fileWriterMock, latexBlockMock, stringToFileConverterMock);
        baseImage = new BaseImage();
        Image image = new Image();
        imageData = GetRandomString();
        fileName = GetRandomString();
        image.setImageData(imageData);
        image.setFileName(fileName);
        baseImage.setImage(image);
    }

    @Test
    void theBlockIsWrittenTest() {
        InOrder inorder = inOrder(stringToFileConverterMock, latexBlockMock, latexBlockMock, latexBlockMock);
        writeBaseImage.write(baseImage);

        inorder.verify(stringToFileConverterMock).convert(imageData, "/tmp/"+fileName);
        inorder.verify(latexBlockMock).begin("figure", "");
        inorder.verify(latexBlockMock).begin("center", "");
        inorder.verify(latexBlockMock).end("center");
        inorder.verify(latexBlockMock).end("figure");
    }

    @Test
    void nullCaptionTest() {
        baseImage.setCaption(null);
        writeBaseImage.write(baseImage);
        verify(fileWriterMock, times(0)).writeLine("\\caption{}");
    }

    @Test
    void emptyCaptionTest() {
        baseImage.setCaption("");
        writeBaseImage.write(baseImage);
        verify(fileWriterMock, times(0)).writeLine("\\caption{}");
    }

    @Test
    void validCaptionTest() {
        String caption = GetRandomString();
        baseImage.setCaption(caption);
        writeBaseImage.write(baseImage);
        verify(fileWriterMock, times(1)).writeLine("\\caption{" + caption +"}");
    }


}