/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import scot.carricksoftware.grantswriter.repositories.censusentry.CensusEntryRepository;
import scot.carricksoftware.grantswriter.repositories.certificates.birthcertificate.BirthCertificateRepository;
import scot.carricksoftware.grantswriter.repositories.people.PersonRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class StatusServiceTest {

    private StatusService statusService;

    @Mock private PersonRepository personRepositoryMock;
    @Mock private BirthCertificateRepository birthCertificateRepositoryMock;
    @Mock private CensusEntryRepository censusEntryRepositoryMock;

    @BeforeEach
    void setUp() {
        statusService = new StatusServiceImpl(personRepositoryMock, birthCertificateRepositoryMock, censusEntryRepositoryMock);
    }

    @Test
    void ReturnTestTest() {
        assertEquals(8, statusService.getStatus().size());
    }

    @Test
    void callsPersonRepositoryTest() {
        when(personRepositoryMock.count()).thenReturn(1);
        statusService.getStatus();
        verify(personRepositoryMock).count();
    }

    @Test
    void callsBirthCertificateRepositoryTest() {
        when(birthCertificateRepositoryMock.count()).thenReturn(1);
        statusService.getStatus();
        verify(birthCertificateRepositoryMock).count();
    }

    @Test
    void callsCensusEntryRepositoryTest() {
        when(censusEntryRepositoryMock.count()).thenReturn(1);
        statusService.getStatus();
        verify(censusEntryRepositoryMock).count();
    }
}