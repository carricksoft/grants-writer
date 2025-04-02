/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:52. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.certificates.marriagecertificates;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

import java.util.List;

@Service
public interface MarriageCertificateService {

    @SuppressWarnings("unused")
    MarriageCertificate findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    MarriageCertificate save(MarriageCertificate marriageCertificate);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<MarriageCertificate> getPagedMarriageCertificates(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    MarriageCertificateCommand saveMarriageCertificateCommand(MarriageCertificateCommand marriageCertificateCommand);

    @SuppressWarnings("unused")
    List<MarriageCertificate> findAll();
}
