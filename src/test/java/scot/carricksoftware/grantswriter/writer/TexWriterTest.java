/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.inOrder;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class TexWriterTest {

    private TexWriter texWriter;

    @Mock
    private FileWriter fileWriterMock;

    @BeforeEach
    void setUp() {
        texWriter = new TexWriterImpl(fileWriterMock);
    }

    @Test
    void initAndCloseTest() throws Exception {
        InOrder inorder = inOrder(fileWriterMock, fileWriterMock);
        texWriter.write(GetRandomString());
        inorder.verify(fileWriterMock).init(anyString());
        inorder.verify(fileWriterMock).close();
    }

}