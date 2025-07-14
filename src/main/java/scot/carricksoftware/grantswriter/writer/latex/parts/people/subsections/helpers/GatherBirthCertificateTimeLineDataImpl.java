/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.certificates.birthcertificate.BirthCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.GatherBirthCertificateFatherTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.GatherBirthCertificateMotherTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.GatherBirthCertificateNewBornTimeLineData;

import java.util.List;

@Component
public class GatherBirthCertificateTimeLineDataImpl implements GatherBirthCertificateTimeLineData {

    private final BirthCertificateService birthCertificateService;

    private final GatherBirthCertificateNewBornTimeLineData gatherBirthCertificateNewBornTimeLineData;

    private final GatherBirthCertificateFatherTimeLineData gatherBirthCertificateFatherTimeLineData;

    private final GatherBirthCertificateMotherTimeLineData gatherBirthCertificateMotherTimeLineData;

    public GatherBirthCertificateTimeLineDataImpl(BirthCertificateService birthCertificateService,
                                                  GatherBirthCertificateNewBornTimeLineData gatherBirthCertificateNewBornTimeLineData, GatherBirthCertificateFatherTimeLineData gatherBirthCertificateFatherTimeLineData, GatherBirthCertificateMotherTimeLineData gatherBirthCertificateMotherTimeLineData) {
        this.birthCertificateService = birthCertificateService;
        this.gatherBirthCertificateNewBornTimeLineData = gatherBirthCertificateNewBornTimeLineData;
        this.gatherBirthCertificateFatherTimeLineData = gatherBirthCertificateFatherTimeLineData;
        this.gatherBirthCertificateMotherTimeLineData = gatherBirthCertificateMotherTimeLineData;
    }

    @Override
    public void gather(Person person) {
        gatherNewBorn(person);
        gatherFather(person);
        gatherMother(person);
    }

    @SuppressWarnings("unused")
    private void gatherNewBorn(Person person) {
        List<BirthCertificate> birthCertificates = birthCertificateService.findAllByNewBorn(person);
        if (!birthCertificates.isEmpty()) {
            gatherBirthCertificateNewBornTimeLineData.gather(birthCertificates);
        }
    }

    @SuppressWarnings("unused")
    private void gatherFather(@SuppressWarnings("unused") Person person) {
        List<BirthCertificate> birthCertificates = birthCertificateService.findAllByFather(person);
        gatherBirthCertificateFatherTimeLineData.gather(birthCertificates);
    }

    @SuppressWarnings("unused")
    private void gatherMother(@SuppressWarnings("unused") Person person) {
        List<BirthCertificate> birthCertificates = birthCertificateService.findAllByMother(person);
        gatherBirthCertificateMotherTimeLineData.gather(birthCertificates);
    }

    @SuppressWarnings("unused")
    private void gatherInformant(@SuppressWarnings("unused") Person person) {
        throw new UnsupportedOperationException();
    }


}
