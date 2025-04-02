/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:52. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.certificates.divorcecertificates;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;

import java.util.List;

@Service
public interface DivorceCertificateService {

    @SuppressWarnings("unused")
    DivorceCertificate findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    DivorceCertificate save(DivorceCertificate divorceCertificate);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<DivorceCertificate> getPagedDivorceCertificates(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    DivorceCertificateCommand saveDivorceCertificateCommand(DivorceCertificateCommand divorceCertificateCommand);

    @SuppressWarnings("unused")
    List<DivorceCertificate> findAll();
}
