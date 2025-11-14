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
import scot.carricksoftware.grantswriter.converters.StringToFileConverter;
import scot.carricksoftware.grantswriter.domains.images.BaseImage;
import scot.carricksoftware.grantswriter.domains.images.Image;
import scot.carricksoftware.grantswriter.writer.FileWriter;

import static org.mockito.Mockito.*;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class WriteBaseImageSizeTest {

    private WriteBaseImage writeBaseImage;

    @Mock
    private FileWriter fileWriterMock;

    @Mock
    private LatexBlock latexBlockMock;

    @Mock
    private StringToFileConverter stringToFileConverterMock;

    private BaseImage baseImage;
    private String fileName;

    @BeforeEach
    void setUp() {
        writeBaseImage = new WriteBaseImageImpl(fileWriterMock, latexBlockMock, stringToFileConverterMock);
        baseImage = new BaseImage();
        Image image = new Image();
        String imageData = GetRandomString();
        fileName = GetRandomString();
        image.setImageData(imageData);
        image.setFileName(fileName);
        baseImage.setImage(image);
    }

    @Test
    void theSizeIsCorrect400Test() {
        checkSize("400", "1.00");
    }

    @Test
    void theSizeIsCorrect800Test() {
        checkSize("800", "2.00");
    }

    private void checkSize(String size, String scale) {
        baseImage.setHeight(size);
        baseImage.setWidth(size);
        writeBaseImage.write(baseImage);
        verify(fileWriterMock).writeLine("\\includegraphics[max width=" +
                scale +
                "\\linewidth,max height=" +
                scale +
                "\\linewidth]{/tmp/" + fileName + "}");
    }


}