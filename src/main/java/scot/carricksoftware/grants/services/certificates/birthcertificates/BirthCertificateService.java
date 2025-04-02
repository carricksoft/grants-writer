/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:52. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.certificates.birthcertificates;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

import java.util.List;

@Service
public interface BirthCertificateService {

    @SuppressWarnings("unused")
    BirthCertificate findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    BirthCertificate save(BirthCertificate birthCertificate);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<BirthCertificate> getPagedBirthCertificates(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    BirthCertificateCommand saveBirthCertificateCommand(BirthCertificateCommand birthCertificateCommand);

    @SuppressWarnings("unused")
    List<BirthCertificate> findAll();
}
