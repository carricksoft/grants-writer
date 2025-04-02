/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates;

import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

public interface MarriageCertificateConverter extends Converter<MarriageCertificate, MarriageCertificateCommand> {

    @Override
    MarriageCertificateCommand convert(@SuppressWarnings("NullableProblems") MarriageCertificate source);

}
