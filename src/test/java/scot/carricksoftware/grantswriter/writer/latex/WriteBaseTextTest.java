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
import scot.carricksoftware.grantswriter.domains.text.BaseText;
import scot.carricksoftware.grantswriter.writer.FileWriter;

import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomInteger;

@ExtendWith(MockitoExtension.class)
class WriteBaseTextTest {

    private WriteBaseText writeBaseText;

    @Mock
    private LatexDivisionHeader latexDivisionHeaderMock;

    @Mock
    private FileWriter fileWriterMock;

    private BaseText baseText;
    private Integer level;
    private String heading;
    private String content;

    @BeforeEach
    void setUp() {
        writeBaseText = new WriteBaseTextImpl(fileWriterMock, latexDivisionHeaderMock);
        baseText = new BaseText();
        level = GetRandomInteger();
        heading = GetRandomString();
        content = GetRandomString();
        baseText.setLevel(level.toString());
        baseText.setHeading(heading);
        baseText.setContent(content);
    }


    @Test
    void theContentIsWrittenTest() {
        writeBaseText.write(baseText);
        verify(fileWriterMock).writeLine(content);
    }

}