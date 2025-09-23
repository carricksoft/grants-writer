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
import scot.carricksoftware.grantswriter.services.text.AppendixTextService;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexDivisionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.headers.AppendixPartHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.helpers.AppendixListSortByOrder;

import static org.mockito.Mockito.verify;

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
    void partHeaderIsCalled(){
        writer.write();
        verify(appendixPartHeaderMock).write();
    }
}