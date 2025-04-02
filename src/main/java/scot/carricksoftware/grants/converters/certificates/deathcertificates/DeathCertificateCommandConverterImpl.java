/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

@SuppressWarnings("unused")
@Component
public class DeathCertificateCommandConverterImpl implements DeathCertificateCommandConverter {

    @Override
    public DeathCertificate convert(DeathCertificateCommand source) {
        DeathCertificate target = new DeathCertificate();

        target.setId(source.getId());
        target.setDeceased(source.getDeceased());

        return target;
    }
}
