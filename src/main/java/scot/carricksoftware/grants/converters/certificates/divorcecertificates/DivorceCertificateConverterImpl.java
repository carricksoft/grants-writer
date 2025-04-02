/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.divorcecertificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;

@SuppressWarnings("unused")

@Component
public class DivorceCertificateConverterImpl implements DivorceCertificateConverter {

    @Override
    public DivorceCertificateCommand convert(DivorceCertificate source) {
        DivorceCertificateCommand target = new DivorceCertificateCommandImpl();

        target.setId(source.getId());
        target.setFirstParty(source.getFirstParty());
        target.setSecondParty(source.getSecondParty());

        return target;
    }
}
