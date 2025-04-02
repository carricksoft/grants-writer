/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.deathcertificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomDeathCertificate;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class DeathCertificateListControllerTest {

    private DeathCertificateListController controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private DeathCertificateService deathCertificateServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<DeathCertificate> deathCertificateListMock;

    @BeforeEach
    public void setUp() {
        controller = new DeathCertificateListControllerImpl(controllerHelperMock, deathCertificateServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(deathCertificateServiceMock.getPagedDeathCertificates(0)).thenReturn(deathCertificateListMock);
        assertEquals("certificates/deathCertificate/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("deathCertificates", deathCertificateListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(deathCertificateServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("certificates/deathCertificate/list", controller.getLastPage(modelMock));
        verify(deathCertificateServiceMock, times(2)).getPagedDeathCertificates(page);
    }

    @Test
    public void deathCertificateDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/deathCertificates", controller.deathCertificateDelete(Long.toString(id)));
        verify(deathCertificateServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<DeathCertificate> deathCertificateList = new ArrayList<>();
        deathCertificateList.add(GetRandomDeathCertificate());
        when(deathCertificateServiceMock.getPagedDeathCertificates(0)).thenReturn(deathCertificateList);

        assertEquals("certificates/deathCertificate/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("deathCertificates", deathCertificateList);
    }

    @Test
    public void getNextPlaceTest() {
        List<DeathCertificate> deathCertificateList = new ArrayList<>();
        deathCertificateList.add(GetRandomDeathCertificate());
        when(deathCertificateServiceMock.getPagedDeathCertificates(0)).thenReturn(deathCertificateList);

        controller.getFirstPage(modelMock);
        assertEquals("certificates/deathCertificate/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("deathCertificates", deathCertificateList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<DeathCertificate> deathCertificateList = new ArrayList<>();
        deathCertificateList.add(GetRandomDeathCertificate());
        when(deathCertificateServiceMock.getPagedDeathCertificates(0)).thenReturn(deathCertificateList);

        controller.getFirstPage(modelMock);
        assertEquals("certificates/deathCertificate/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("deathCertificates", deathCertificateList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(deathCertificateServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("certificates/deathCertificate/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
