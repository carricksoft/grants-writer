/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.birthcertificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

@SuppressWarnings("unused")

@Component
public class BirthCertificateConverterImpl implements BirthCertificateConverter {

    @Override
    public BirthCertificateCommand convert(BirthCertificate source) {
        BirthCertificateCommand target = new BirthCertificateCommandImpl();

        target.setId(source.getId());
        target.setNewBorn(source.getNewBorn());

        return target;
    }
}
