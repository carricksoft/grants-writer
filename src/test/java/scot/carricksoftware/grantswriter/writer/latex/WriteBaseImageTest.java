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

import static org.mockito.Mockito.inOrder;

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

    private Image image;

    @BeforeEach
    void setUp() {
        writeBaseImage = new WriteBaseImageImpl(fileWriterMock, latexBlockMock, stringToFileConverterMock);
        baseImage = new BaseImage();
        image = new Image();
    }

    @Test
    void theBlockIsWrittenTest() {
        baseImage.setImage(image);
        InOrder inorder = inOrder(latexBlockMock, latexBlockMock, latexBlockMock, latexBlockMock);
        writeBaseImage.write(baseImage);

        inorder.verify(latexBlockMock).begin("figure", "");
        inorder.verify(latexBlockMock).begin("center", "");
        inorder.verify(latexBlockMock).end("center");
        inorder.verify(latexBlockMock).end("figure");
    }

}