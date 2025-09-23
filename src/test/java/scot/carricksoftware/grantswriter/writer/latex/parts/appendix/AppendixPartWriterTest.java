/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.appendix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.text.AppendixText;
import scot.carricksoftware.grantswriter.services.text.AppendixTextService;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexDivisionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.headers.AppendixPartHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.helpers.AppendixListSortByOrder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomInteger;

@ExtendWith(MockitoExtension.class)
class AppendixPartWriterTest {

    private AppendixPartWriter writer;

    @Mock private AppendixPartHeader appendixPartHeaderMock;
    @Mock private AppendixTextService appendixTextServiceMock;
    @Mock private FileWriter fileWriterMock;
    @Mock private LatexDivisionHeader latexDivisionHeaderMock;
    @Mock private AppendixListSortByOrder appendixListSortByOrderMock;

    @BeforeEach
    void setUp() {
        writer = new AppendixPartWriterImpl(appendixPartHeaderMock,
                appendixTextServiceMock,
                fileWriterMock,
                latexDivisionHeaderMock,
                appendixListSortByOrderMock);
    }

    @Test
    void partHeaderIsCalledTest() {
        writer.write();
        verify(appendixPartHeaderMock).write();
    }

    @Test
    void theContentsAreWrittenTest() {
        AppendixText appendixText = new AppendixText();
        String contents = GetRandomString();
        appendixText.setContent(contents);
        List<AppendixText> appendixTextList = new ArrayList<>();
        appendixTextList.add(appendixText);
        when(appendixTextServiceMock.findAll()).thenReturn(appendixTextList);

        writer.write();
        verify(fileWriterMock).writeLine(contents);
    }

    @Test
    void theHeadingIsWrittenTest() {
        AppendixText appendixText = new AppendixText();
        String heading = GetRandomString();
        appendixText.setHeading(heading);
        Integer level = GetRandomInteger();
        appendixText.setLevel(level.toString());
        List<AppendixText> appendixTextList = new ArrayList<>();
        appendixTextList.add(appendixText);
        when(appendixTextServiceMock.findAll()).thenReturn(appendixTextList);

        writer.write();
        verify(latexDivisionHeaderMock).write(level, heading);
    }

    @Test
    void theTextIsSortedTest() {
        AppendixText appendixText = new AppendixText();
        List<AppendixText> appendixTextList = new ArrayList<>();
        appendixTextList.add(appendixText);
        when(appendixTextServiceMock.findAll()).thenReturn(appendixTextList);

        writer.write();
        verify(appendixListSortByOrderMock).sort(appendixTextList);
    }
}