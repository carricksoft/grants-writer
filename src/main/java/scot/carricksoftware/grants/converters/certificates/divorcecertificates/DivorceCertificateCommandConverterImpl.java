/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.divorcecertificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;

@Component
public class DivorceCertificateCommandConverterImpl implements DivorceCertificateCommandConverter {

    @Override
    public DivorceCertificate convert(DivorceCertificateCommand source) {
        DivorceCertificate target = new DivorceCertificate();

        target.setId(source.getId());
        target.setFirstParty(source.getFirstParty());
        target.setSecondParty(source.getSecondParty());

        return target;
    }
}
