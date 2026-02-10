/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.certificates.birthcertificate.BirthCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate.GatherBirthCertificateFatherTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate.GatherBirthCertificateInformantTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate.GatherBirthCertificateMotherTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate.GatherBirthCertificateNewBornTimeLineData;

import java.util.List;

@Component
public class GatherPeopleBirthCertificateTimeLineDataImpl implements GatherPeopleBirthCertificateTimeLineData {

    private final BirthCertificateService birthCertificateService;

    private final GatherBirthCertificateNewBornTimeLineData gatherBirthCertificateNewBornTimeLineData;

    private final GatherBirthCertificateFatherTimeLineData gatherBirthCertificateFatherTimeLineData;

    private final GatherBirthCertificateMotherTimeLineData gatherBirthCertificateMotherTimeLineData;

    private final GatherBirthCertificateInformantTimeLineData gatherBirthCertificateInformantTimeLineData;

    public GatherPeopleBirthCertificateTimeLineDataImpl(BirthCertificateService birthCertificateService,
                                                        GatherBirthCertificateNewBornTimeLineData gatherBirthCertificateNewBornTimeLineData,
                                                        GatherBirthCertificateFatherTimeLineData gatherBirthCertificateFatherTimeLineData,
                                                        GatherBirthCertificateMotherTimeLineData gatherBirthCertificateMotherTimeLineData,
                                                        GatherBirthCertificateInformantTimeLineData gatherBirthCertificateInformantTimeLineData) {
        this.birthCertificateService = birthCertificateService;
        this.gatherBirthCertificateNewBornTimeLineData = gatherBirthCertificateNewBornTimeLineData;
        this.gatherBirthCertificateFatherTimeLineData = gatherBirthCertificateFatherTimeLineData;
        this.gatherBirthCertificateMotherTimeLineData = gatherBirthCertificateMotherTimeLineData;
        this.gatherBirthCertificateInformantTimeLineData = gatherBirthCertificateInformantTimeLineData;
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
            gatherBirthCertificateNewBornTimeLineData.gather(birthCertificates);
        }
    }

    private void gatherFather(Person person) {
        List<BirthCertificate> birthCertificates = birthCertificateService.findAllByFather(person);
        gatherBirthCertificateFatherTimeLineData.gather(birthCertificates);
    }

    private void gatherMother(Person person) {
        List<BirthCertificate> birthCertificates = birthCertificateService.findAllByMother(person);
        gatherBirthCertificateMotherTimeLineData.gather(birthCertificates);
    }

    private void gatherInformant(Person person) {
        List<BirthCertificate> birthCertificates = birthCertificateService.findAllByInformant(person);
        gatherBirthCertificateInformantTimeLineData.gather(birthCertificates);
    }


}
