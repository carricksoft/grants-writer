/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.certificates.divorcecertificates;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.constants.MappingConstants;

@SuppressWarnings("unused")

public interface DivorceCertificateFormController {

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DIVORCE_CERTIFICATE_NEW)
    String getNewDivorceCertificate(Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DIVORCE_CERTIFICATE_EDIT)
    String divorceCertificateEdit(@Valid @PathVariable String id, Model model);

    String saveOrUpdate(@ModelAttribute DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult, Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DIVORCE_CERTIFICATE_SHOW)
    String showById(@PathVariable String id, Model model);
}
