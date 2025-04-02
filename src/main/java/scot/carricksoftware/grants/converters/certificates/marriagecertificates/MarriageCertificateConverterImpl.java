/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

@SuppressWarnings("unused")

@Component
public class MarriageCertificateConverterImpl implements MarriageCertificateConverter {

    @Override
    public MarriageCertificateCommand convert(MarriageCertificate source) {
        MarriageCertificateCommand target = new MarriageCertificateCommandImpl();

        target.setId(source.getId());
        target.setBride(source.getBride());
        target.setGroom(source.getGroom());

        return target;
    }
}
