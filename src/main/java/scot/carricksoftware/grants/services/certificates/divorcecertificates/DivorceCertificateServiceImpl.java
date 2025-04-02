/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:52. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.certificates.divorcecertificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.certificates.divorcecertificates.DivorceCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.divorcecertificates.DivorceCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.repositories.certificates.DivorceCertificateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DivorceCertificateServiceImpl implements DivorceCertificateService {
    private static final Logger logger = LogManager.getLogger(DivorceCertificateServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final DivorceCertificateRepository divorceCertificateRepository;
    private final DivorceCertificateConverterImpl divorceCertificateConverterImpl;
    private final DivorceCertificateCommandConverterImpl divorceCertificateCommandConverterImpl;

    public DivorceCertificateServiceImpl(
            DivorceCertificateRepository divorceCertificateRepository,
            DivorceCertificateConverterImpl divorceCertificateConverterImpl,
            DivorceCertificateCommandConverterImpl divorceCertificateCommandConverterImpl) {

        this.divorceCertificateRepository = divorceCertificateRepository;
        this.divorceCertificateConverterImpl = divorceCertificateConverterImpl;
        this.divorceCertificateCommandConverterImpl = divorceCertificateCommandConverterImpl;
    }


    @Override
    public DivorceCertificate findById(Long id) {
        logger.debug("DivorceCertificateServiceImpl::findById");
        Optional<DivorceCertificate> divorceCertificate = divorceCertificateRepository.findById(id);
        return divorceCertificate.orElse(null);
    }

    @Override
    public DivorceCertificate save(DivorceCertificate divorceCertificate) {
        logger.debug("DivorceCertificateServiceImpl::save");
        return divorceCertificateRepository.save(divorceCertificate);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("DivorceCertificateServiceImpl::deleteBy");
        divorceCertificateRepository.deleteById(id);
    }


    @Override
    public List<DivorceCertificate> getPagedDivorceCertificates(int pageNumber) {
        logger.debug("DivorceCertificateServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<DivorceCertificate> pagedResult = divorceCertificateRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("DivorceCertificateServiceImpl::count");
        return divorceCertificateRepository.count();
    }

    @Transactional
    @Override
    public DivorceCertificateCommand saveDivorceCertificateCommand(DivorceCertificateCommand divorceCertificateCommand) {
        logger.debug("DivorceCertificateServiceImpl::saveDivorceCertificateCommand");
        DivorceCertificate divorceCertificate = divorceCertificateCommandConverterImpl.convert(divorceCertificateCommand);
        DivorceCertificate savedDivorceCertificate = divorceCertificateRepository.save(divorceCertificate);
        return divorceCertificateConverterImpl.convert(savedDivorceCertificate);

    }

    @Override
    public List<DivorceCertificate> findAll() {
        logger.debug("DivorceCertificateServiceImpl::findAll");
        List<DivorceCertificate> result = new ArrayList<>();
        Iterable<DivorceCertificate> divorceCertificateIterable = divorceCertificateRepository.findAll();
        divorceCertificateIterable.forEach(result::add);
        return result;
    }

}
