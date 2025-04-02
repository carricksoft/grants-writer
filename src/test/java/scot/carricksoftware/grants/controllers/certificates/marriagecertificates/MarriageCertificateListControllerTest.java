/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.marriagecertificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.MarriageCertificateService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomMarriageCertificate;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class MarriageCertificateListControllerTest {

    private MarriageCertificateListController controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private MarriageCertificateService marriageCertificateServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<MarriageCertificate> marriageCertificateListMock;

    @BeforeEach
    public void setUp() {
        controller = new MarriageCertificateListControllerImpl(controllerHelperMock, marriageCertificateServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(marriageCertificateServiceMock.getPagedMarriageCertificates(0)).thenReturn(marriageCertificateListMock);
        assertEquals("certificates/marriageCertificate/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("marriageCertificates", marriageCertificateListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(marriageCertificateServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("certificates/marriageCertificate/list", controller.getLastPage(modelMock));
        verify(marriageCertificateServiceMock, times(2)).getPagedMarriageCertificates(page);
    }

    @Test
    public void marriageCertificateDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/marriageCertificates", controller.marriageCertificateDelete(Long.toString(id)));
        verify(marriageCertificateServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<MarriageCertificate> marriageCertificateList = new ArrayList<>();
        marriageCertificateList.add(GetRandomMarriageCertificate());
        when(marriageCertificateServiceMock.getPagedMarriageCertificates(0)).thenReturn(marriageCertificateList);

        assertEquals("certificates/marriageCertificate/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("marriageCertificates", marriageCertificateList);
    }

    @Test
    public void getNextPlaceTest() {
        List<MarriageCertificate> marriageCertificateList = new ArrayList<>();
        marriageCertificateList.add(GetRandomMarriageCertificate());
        when(marriageCertificateServiceMock.getPagedMarriageCertificates(0)).thenReturn(marriageCertificateList);

        controller.getFirstPage(modelMock);
        assertEquals("certificates/marriageCertificate/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("marriageCertificates", marriageCertificateList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<MarriageCertificate> marriageCertificateList = new ArrayList<>();
        marriageCertificateList.add(GetRandomMarriageCertificate());
        when(marriageCertificateServiceMock.getPagedMarriageCertificates(0)).thenReturn(marriageCertificateList);

        controller.getFirstPage(modelMock);
        assertEquals("certificates/marriageCertificate/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("marriageCertificates", marriageCertificateList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(marriageCertificateServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("certificates/marriageCertificate/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
