/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:52. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.certificates.birthcertificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.repositories.certificates.BirthCertificateRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BirthCertificateServiceImpl implements BirthCertificateService {
    private static final Logger logger = LogManager.getLogger(BirthCertificateServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final BirthCertificateRepository birthCertificateRepository;
    private final BirthCertificateConverterImpl birthCertificateConverterImpl;
    private final BirthCertificateCommandConverterImpl birthCertificateCommandConverterImpl;

    public BirthCertificateServiceImpl(
            BirthCertificateRepository birthCertificateRepository,
            BirthCertificateConverterImpl birthCertificateConverterImpl,
            BirthCertificateCommandConverterImpl birthCertificateCommandConverterImpl) {

        this.birthCertificateRepository = birthCertificateRepository;
        this.birthCertificateConverterImpl = birthCertificateConverterImpl;
        this.birthCertificateCommandConverterImpl = birthCertificateCommandConverterImpl;
    }


    @Override
    public BirthCertificate findById(Long id) {
        logger.debug("BirthCertificateServiceImpl::findById");
        Optional<BirthCertificate> birthCertificate = birthCertificateRepository.findById(id);
        return birthCertificate.orElse(null);
    }

    @Override
    public BirthCertificate save(BirthCertificate birthCertificate) {
        logger.debug("BirthCertificateServiceImpl::save");
        return birthCertificateRepository.save(birthCertificate);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("BirthCertificateServiceImpl::deleteBy");
        birthCertificateRepository.deleteById(id);
    }


    @Override
    public List<BirthCertificate> getPagedBirthCertificates(int pageNumber) {
        logger.debug("BirthCertificateServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<BirthCertificate> pagedResult = birthCertificateRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("BirthCertificateServiceImpl::count");
        return birthCertificateRepository.count();
    }

    @Transactional
    @Override
    public BirthCertificateCommand saveBirthCertificateCommand(BirthCertificateCommand birthCertificateCommand) {
        logger.debug("BirthCertificateServiceImpl::saveBirthCertificateCommand");
        BirthCertificate birthCertificate = birthCertificateCommandConverterImpl.convert(birthCertificateCommand);
        BirthCertificate savedBirthCertificate = birthCertificateRepository.save(birthCertificate);
        return birthCertificateConverterImpl.convert(savedBirthCertificate);

    }

    @Override
    public List<BirthCertificate> findAll() {
        logger.debug("BirthCertificateServiceImpl::findAll");
        List<BirthCertificate> result = new ArrayList<>();
        Iterable<BirthCertificate> birthCertificateIterable = birthCertificateRepository.findAll();
        birthCertificateIterable.forEach(result::add);
        return result;
    }

}
