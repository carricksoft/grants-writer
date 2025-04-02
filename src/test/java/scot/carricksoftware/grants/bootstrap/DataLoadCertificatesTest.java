package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
public class DataLoadCertificatesTest {

    private DataLoadCertificates dataLoadCertificates;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;

    @Mock
    private DeathCertificateService deathCertificateServiceMock;

    @Mock
    private PersonService personServiceMock;


    @BeforeEach
    public void setUp() {
        dataLoadCertificates = new DataLoadCertificates(birthCertificateServiceMock,
                deathCertificateServiceMock,
                personServiceMock);
    }

    @Test
    public void birthCertificatesAreLoadedTest() {
        Person person = GetRandomPerson();
        when(personServiceMock.findById(1L)).thenReturn(person);
        ArgumentCaptor<BirthCertificate> captor = ArgumentCaptor.forClass(BirthCertificate.class);

        dataLoadCertificates.load();

        verify(birthCertificateServiceMock).save(captor.capture());
        assertEquals(person, captor.getValue().getNewBorn());
    }

    @Test
    public void deathCertificatesAreLoadedTest() {
        Person person = GetRandomPerson();
        when(personServiceMock.findById(1L)).thenReturn(person);
        ArgumentCaptor<DeathCertificate> captor = ArgumentCaptor.forClass(DeathCertificate.class);

        dataLoadCertificates.load();

        verify(deathCertificateServiceMock).save(captor.capture());
        assertEquals(person, captor.getValue().getDeceased());

    }


}