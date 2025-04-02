/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.certificates.birthcertificates;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.constants.MappingConstants;

@SuppressWarnings("unused")

public interface BirthCertificateFormController {

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTH_CERTIFICATE_NEW)
    String getNewBirthCertificate(Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTH_CERTIFICATE_EDIT)
    String birthCertificateEdit(@Valid @PathVariable String id, Model model);

    String saveOrUpdate(@ModelAttribute BirthCertificateCommand countryCommand, BindingResult bindingResult, Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTH_CERTIFICATE_SHOW)
    String showById(@PathVariable String id, Model model);
}
