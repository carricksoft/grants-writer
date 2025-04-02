/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;

import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

public interface DeathCertificateConverter extends Converter<DeathCertificate, DeathCertificateCommand> {

    @Override
    DeathCertificateCommand convert(@SuppressWarnings("NullableProblems") DeathCertificate source);

}
