/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LatexWriterTest {

    private LatexWriter writer;

    @BeforeEach
    void setUp() {
        writer = new LatexWriterImpl();
    }

    @Test
    void openAFileTest() {
        String filename = System.getProperty("user.home") + File.separator + "test.tex";
        assertTrue(writer.open(filename));
    }

    @Test
    void openInAProtectedFileTest() {
        String filename = "/" + File.separator + "test.tex";
        assertFalse(writer.open(filename));
    }

    @Test
    void isOpenIsFirstClosedTest() {
        assertFalse(writer.isOpen());
    }

    @Test
    void isOpenIsTrueAfterAFileIsOpenTest() {
        writer.open(System.getProperty("user.home") + File.separator + "test.tex");
        assertTrue(writer.isOpen());
    }

    @Test
    void isOpenIsFalseAfterAFileIsClosedTest() {
        writer.open(System.getProperty("user.home") + File.separator + "test.tex");
        assertTrue(writer.isOpen());
        writer.close();
        assertFalse(writer.isOpen());
    }




}