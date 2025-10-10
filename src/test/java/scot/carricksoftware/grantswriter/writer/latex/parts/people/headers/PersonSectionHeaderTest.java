/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.headers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.converters.StringToFileConverter;
import scot.carricksoftware.grantswriter.domains.images.Image;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexBlock;
import scot.carricksoftware.grantswriter.writer.latex.LatexSectionHeader;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class PersonSectionHeaderTest {

    private PersonSectionHeader personSectionHeader;

    @Mock LatexSectionHeader latexSectionHeaderMock;
    @Mock Person personMock;
    @Mock Image imageMock;
    @Mock FileWriter fileWriterMock;
    @Mock LatexBlock latexBlockMock;
    @Mock StringToFileConverter stringToFileConverterMock;


    @BeforeEach
    void setUp() {
        personSectionHeader = new PersonSectionHeaderImpl(
                latexSectionHeaderMock,
                fileWriterMock,
                latexBlockMock,
                stringToFileConverterMock);
        when(personMock.getImage()).thenReturn(imageMock);
    }

    @Test
    void actualImageIsCreatedTest() {
        String imageData = GetRandomString();
        when(imageMock.getImageData()).thenReturn(imageData);
        String fileName =  GetRandomString();
        when(imageMock.getFileName()).thenReturn(fileName);

        personSectionHeader.write(personMock);
        verify(stringToFileConverterMock).convert(imageData, "/tmp/" + fileName);
    }

    @Test
    void theSectionHeaderIsWrittenTest() {
        String personString = GetRandomString();
        when(personMock.toString()).thenReturn(personString);

        personSectionHeader.write(personMock);
        verify(latexSectionHeaderMock).write(personString);
    }

    @Test
    void theImageBlockIsWrittenTest() {
        personSectionHeader.write(personMock);
        verify(latexBlockMock).begin("center","");
        verify(latexBlockMock).end("center");
    }

    @Test
    void theFileWriterIsWrittenTest() {
        String fileName =  GetRandomString();
        when(imageMock.getFileName()).thenReturn(fileName);
        when(personMock.getImage()).thenReturn(imageMock);

        personSectionHeader.write(personMock);
        //noinspection SpellCheckingInspection
        verify(fileWriterMock).writeLine("\\includegraphics[width=0.25\\linewidth]{/tmp/" + fileName + "}");

    }


}