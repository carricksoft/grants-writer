/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.documenttext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.text.DocumentText;
import scot.carricksoftware.grants.services.text.documenttext.DocumentTextService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomDocumentText;


@ExtendWith(MockitoExtension.class)
public class DocumentTextListControllerTest {

    private DocumentTextListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private DocumentTextService documentTextServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<DocumentText> documentTextListMock;

    @BeforeEach
    public void setUp() {
        controller = new DocumentTextListControllerImpl(controllerHelperMock, documentTextServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(documentTextServiceMock.getPagedDocumentTexts(0)).thenReturn(documentTextListMock);
        assertEquals("text/documentText/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("documentTexts", documentTextListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(documentTextServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("text/documentText/list", controller.getLastPage(modelMock));
        verify(documentTextServiceMock, times(2)).getPagedDocumentTexts(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/documentTexts", controller.DocumentTextDelete(Long.toString(id)));
        verify(documentTextServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<DocumentText> documentTextList = new ArrayList<>();
        documentTextList.add(GetRandomDocumentText());
        when(documentTextServiceMock.getPagedDocumentTexts(0)).thenReturn(documentTextList);

        assertEquals("text/documentText/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("documentTexts", documentTextList);
    }

    @Test
    public void getNextPlaceTest() {
        List<DocumentText> documentTextList = new ArrayList<>();
        documentTextList.add(GetRandomDocumentText());
        when(documentTextServiceMock.getPagedDocumentTexts(0)).thenReturn(documentTextList);

        controller.getFirstPage(modelMock);
        assertEquals("text/documentText/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("documentTexts", documentTextList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<DocumentText> documentTextList = new ArrayList<>();
        documentTextList.add(GetRandomDocumentText());
        when(documentTextServiceMock.getPagedDocumentTexts(0)).thenReturn(documentTextList);

        controller.getFirstPage(modelMock);
        assertEquals("text/documentText/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("documentTexts", documentTextList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(documentTextServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("text/documentText/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
