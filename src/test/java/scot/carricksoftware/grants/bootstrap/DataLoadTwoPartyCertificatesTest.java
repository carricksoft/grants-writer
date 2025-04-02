package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.certificates.divorcecertificates.DivorceCertificateService;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.MarriageCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
public class DataLoadTwoPartyCertificatesTest {

    private DataLoadTwoPartyCertificates dataLoadTwoPartyCertificates;

    @Mock
    private MarriageCertificateService marriageCertificateServiceMock;

    @Mock
    private DivorceCertificateService divorceCertificateServiceMock;

    @Mock
    private PersonService personServiceMock;

    @BeforeEach
    public void setUp() {
        dataLoadTwoPartyCertificates = new DataLoadTwoPartyCertificates(marriageCertificateServiceMock,
                divorceCertificateServiceMock,
                personServiceMock);
    }

    @Test
    public void MarriageCertificatesAreLoadedTest() {
        ArgumentCaptor<MarriageCertificate> captor = ArgumentCaptor.forClass(MarriageCertificate.class);
        Person person1 = GetRandomPerson();
        Person person2 = GetRandomPerson();
        when(personServiceMock.findById(1L)).thenReturn(person1);
        when(personServiceMock.findById(2L)).thenReturn(person2);

        dataLoadTwoPartyCertificates.load();
        verify(marriageCertificateServiceMock).save(captor.capture());

        assertEquals(person1, captor.getValue().getGroom());
        assertEquals(person2, captor.getValue().getBride());
    }

    @Test
    public void divorceCertificatesAreLoadedTest() {
        ArgumentCaptor<DivorceCertificate> captor = ArgumentCaptor.forClass(DivorceCertificate.class);
        Person person1 = GetRandomPerson();
        Person person2 = GetRandomPerson();
        when(personServiceMock.findById(1L)).thenReturn(person1);
        when(personServiceMock.findById(2L)).thenReturn(person2);

        dataLoadTwoPartyCertificates.load();

        verify(divorceCertificateServiceMock).save(captor.capture());
        assertEquals(person1, captor.getValue().getFirstParty());
        assertEquals(person2, captor.getValue().getSecondParty());
    }


}