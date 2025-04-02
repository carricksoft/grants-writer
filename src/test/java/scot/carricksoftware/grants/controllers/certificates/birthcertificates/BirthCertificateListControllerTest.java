/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.birthcertificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomBirthCertificate;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class BirthCertificateListControllerTest {

    private BirthCertificateListController controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<BirthCertificate> birthCertificateListMock;

    @BeforeEach
    public void setUp() {
        controller = new BirthCertificateListControllerImpl(controllerHelperMock, birthCertificateServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(birthCertificateServiceMock.getPagedBirthCertificates(0)).thenReturn(birthCertificateListMock);
        assertEquals("certificates/birthCertificate/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("birthCertificates", birthCertificateListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(birthCertificateServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("certificates/birthCertificate/list", controller.getLastPage(modelMock));
        verify(birthCertificateServiceMock, times(2)).getPagedBirthCertificates(page);
    }

    @Test
    public void birthCertificateDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/birthCertificates", controller.birthCertificateDelete(Long.toString(id)));
        verify(birthCertificateServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<BirthCertificate> birthCertificateList = new ArrayList<>();
        birthCertificateList.add(GetRandomBirthCertificate());
        when(birthCertificateServiceMock.getPagedBirthCertificates(0)).thenReturn(birthCertificateList);

        assertEquals("certificates/birthCertificate/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("birthCertificates", birthCertificateList);
    }

    @Test
    public void getNextPlaceTest() {
        List<BirthCertificate> birthCertificateList = new ArrayList<>();
        birthCertificateList.add(GetRandomBirthCertificate());
        when(birthCertificateServiceMock.getPagedBirthCertificates(0)).thenReturn(birthCertificateList);

        controller.getFirstPage(modelMock);
        assertEquals("certificates/birthCertificate/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("birthCertificates", birthCertificateList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<BirthCertificate> birthCertificateList = new ArrayList<>();
        birthCertificateList.add(GetRandomBirthCertificate());
        when(birthCertificateServiceMock.getPagedBirthCertificates(0)).thenReturn(birthCertificateList);

        controller.getFirstPage(modelMock);
        assertEquals("certificates/birthCertificate/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("birthCertificates", birthCertificateList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(birthCertificateServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("certificates/birthCertificate/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
