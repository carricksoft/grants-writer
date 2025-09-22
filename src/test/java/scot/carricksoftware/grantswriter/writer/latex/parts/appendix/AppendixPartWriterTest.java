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
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.headers.AppendixPartHeader;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AppendixPartWriterTest {

    private AppendixPartWriter writer;

    @Mock
    private AppendixPartHeader appendixPartHeaderMock;

    @BeforeEach
    void setUp() {
        writer = new AppendixPartWriterImpl(appendixPartHeaderMock);
    }

    @Test
    void partHeaderIsCalled(){
        writer.write();
        verify(appendixPartHeaderMock).write();
    }
}