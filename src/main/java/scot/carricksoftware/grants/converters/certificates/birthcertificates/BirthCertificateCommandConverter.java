/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.birthcertificates;

import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

public interface BirthCertificateCommandConverter extends Converter<BirthCertificateCommand, BirthCertificate> {

    @Override
    BirthCertificate convert(@SuppressWarnings("NullableProblems") BirthCertificateCommand source);

}
