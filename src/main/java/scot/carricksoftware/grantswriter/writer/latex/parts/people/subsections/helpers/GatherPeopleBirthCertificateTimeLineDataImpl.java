/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.certificates.birthcertificate.BirthCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate.GatherPeopleBirthCertificateFatherTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate.GatherPeopleBirthCertificateInformantTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate.GatherPeopleBirthCertificateMotherTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate.GatherPeopleBirthCertificateNewBornTimeLineData;

import java.util.List;

@Component
public class GatherPeopleBirthCertificateTimeLineDataImpl implements GatherPeopleBirthCertificateTimeLineData {

    private final BirthCertificateService birthCertificateService;

    private final GatherPeopleBirthCertificateNewBornTimeLineData gatherPeopleBirthCertificateNewBornTimeLineData;

    private final GatherPeopleBirthCertificateFatherTimeLineData gatherPeopleBirthCertificateFatherTimeLineData;

    private final GatherPeopleBirthCertificateMotherTimeLineData gatherPeopleBirthCertificateMotherTimeLineData;

    private final GatherPeopleBirthCertificateInformantTimeLineData gatherPeopleBirthCertificateInformantTimeLineData;

    public GatherPeopleBirthCertificateTimeLineDataImpl(BirthCertificateService birthCertificateService,
                                                        GatherPeopleBirthCertificateNewBornTimeLineData gatherPeopleBirthCertificateNewBornTimeLineData,
                                                        GatherPeopleBirthCertificateFatherTimeLineData gatherPeopleBirthCertificateFatherTimeLineData,
                                                        GatherPeopleBirthCertificateMotherTimeLineData gatherPeopleBirthCertificateMotherTimeLineData,
                                                        GatherPeopleBirthCertificateInformantTimeLineData gatherPeopleBirthCertificateInformantTimeLineData) {
        this.birthCertificateService = birthCertificateService;
        this.gatherPeopleBirthCertificateNewBornTimeLineData = gatherPeopleBirthCertificateNewBornTimeLineData;
        this.gatherPeopleBirthCertificateFatherTimeLineData = gatherPeopleBirthCertificateFatherTimeLineData;
        this.gatherPeopleBirthCertificateMotherTimeLineData = gatherPeopleBirthCertificateMotherTimeLineData;
        this.gatherPeopleBirthCertificateInformantTimeLineData = gatherPeopleBirthCertificateInformantTimeLineData;
    }

    @Override
    public void gather(Person person) {
        gatherNewBorn(person);
        gatherFather(person);
        gatherMother(person);
        gatherInformant(person);
    }

    private void gatherNewBorn(Person person) {
        List<BirthCertificate> birthCertificates = birthCertificateService.findAllByNewBorn(person);
        if (!birthCertificates.isEmpty()) {
            gatherPeopleBirthCertificateNewBornTimeLineData.gather(birthCertificates);
        }
    }

    private void gatherFather(Person person) {
        List<BirthCertificate> birthCertificates = birthCertificateService.findAllByFather(person);
        gatherPeopleBirthCertificateFatherTimeLineData.gather(birthCertificates);
    }

    private void gatherMother(Person person) {
        List<BirthCertificate> birthCertificates = birthCertificateService.findAllByMother(person);
        gatherPeopleBirthCertificateMotherTimeLineData.gather(birthCertificates);
    }

    private void gatherInformant(Person person) {
        List<BirthCertificate> birthCertificates = birthCertificateService.findAllByInformant(person);
        gatherPeopleBirthCertificateInformantTimeLineData.gather(birthCertificates);
    }


}
