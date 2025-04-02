/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.divorcecertificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.services.certificates.divorcecertificates.DivorceCertificateService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomDivorceCertificate;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class DivorceCertificateListControllerTest {

    private DivorceCertificateListController controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private DivorceCertificateService divorceCertificateServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<DivorceCertificate> divorceCertificateListMock;

    @BeforeEach
    public void setUp() {
        controller = new DivorceCertificateListControllerImpl(controllerHelperMock, divorceCertificateServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(divorceCertificateServiceMock.getPagedDivorceCertificates(0)).thenReturn(divorceCertificateListMock);
        assertEquals("certificates/divorceCertificate/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("divorceCertificates", divorceCertificateListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(divorceCertificateServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("certificates/divorceCertificate/list", controller.getLastPage(modelMock));
        verify(divorceCertificateServiceMock, times(2)).getPagedDivorceCertificates(page);
    }

    @Test
    public void divorceCertificateDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/divorceCertificates", controller.divorceCertificateDelete(Long.toString(id)));
        verify(divorceCertificateServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<DivorceCertificate> divorceCertificateList = new ArrayList<>();
        divorceCertificateList.add(GetRandomDivorceCertificate());
        when(divorceCertificateServiceMock.getPagedDivorceCertificates(0)).thenReturn(divorceCertificateList);

        assertEquals("certificates/divorceCertificate/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("divorceCertificates", divorceCertificateList);
    }

    @Test
    public void getNextPlaceTest() {
        List<DivorceCertificate> divorceCertificateList = new ArrayList<>();
        divorceCertificateList.add(GetRandomDivorceCertificate());
        when(divorceCertificateServiceMock.getPagedDivorceCertificates(0)).thenReturn(divorceCertificateList);

        controller.getFirstPage(modelMock);
        assertEquals("certificates/divorceCertificate/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("divorceCertificates", divorceCertificateList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<DivorceCertificate> divorceCertificateList = new ArrayList<>();
        divorceCertificateList.add(GetRandomDivorceCertificate());
        when(divorceCertificateServiceMock.getPagedDivorceCertificates(0)).thenReturn(divorceCertificateList);

        controller.getFirstPage(modelMock);
        assertEquals("certificates/divorceCertificate/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("divorceCertificates", divorceCertificateList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(divorceCertificateServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("certificates/divorceCertificate/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
