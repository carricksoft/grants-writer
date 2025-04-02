/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:53. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.certificates.deathcertificates;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

import java.util.List;

@Service
public interface DeathCertificateService {

    @SuppressWarnings("unused")
    DeathCertificate findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    DeathCertificate save(DeathCertificate deathCertificate);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<DeathCertificate> getPagedDeathCertificates(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    DeathCertificateCommand saveDeathCertificateCommand(DeathCertificateCommand deathCertificateCommand);

    @SuppressWarnings("unused")
    List<DeathCertificate> findAll();
}
