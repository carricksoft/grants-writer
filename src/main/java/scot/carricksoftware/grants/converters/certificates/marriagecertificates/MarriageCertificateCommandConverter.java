/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates;

import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

public interface MarriageCertificateCommandConverter extends Converter<MarriageCertificateCommand, MarriageCertificate> {

    @Override
    MarriageCertificate convert(@SuppressWarnings("NullableProblems") MarriageCertificateCommand source);

}
