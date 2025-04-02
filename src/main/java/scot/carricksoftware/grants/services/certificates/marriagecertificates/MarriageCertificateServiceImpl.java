/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:52. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.certificates.marriagecertificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.repositories.certificates.MarriageCertificateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MarriageCertificateServiceImpl implements MarriageCertificateService {
    private static final Logger logger = LogManager.getLogger(MarriageCertificateServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final MarriageCertificateRepository marriageCertificateRepository;
    private final MarriageCertificateConverterImpl marriageCertificateConverterImpl;
    private final MarriageCertificateCommandConverterImpl marriageCertificateCommandConverterImpl;

    public MarriageCertificateServiceImpl(
            MarriageCertificateRepository marriageCertificateRepository,
            MarriageCertificateConverterImpl marriageCertificateConverterImpl,
            MarriageCertificateCommandConverterImpl marriageCertificateCommandConverterImpl) {

        this.marriageCertificateRepository = marriageCertificateRepository;
        this.marriageCertificateConverterImpl = marriageCertificateConverterImpl;
        this.marriageCertificateCommandConverterImpl = marriageCertificateCommandConverterImpl;
    }


    @Override
    public MarriageCertificate findById(Long id) {
        logger.debug("MarriageCertificateServiceImpl::findById");
        Optional<MarriageCertificate> marriageCertificate = marriageCertificateRepository.findById(id);
        return marriageCertificate.orElse(null);
    }

    @Override
    public MarriageCertificate save(MarriageCertificate marriageCertificate) {
        logger.debug("MarriageCertificateServiceImpl::save");
        return marriageCertificateRepository.save(marriageCertificate);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("MarriageCertificateServiceImpl::deleteBy");
        marriageCertificateRepository.deleteById(id);
    }


    @Override
    public List<MarriageCertificate> getPagedMarriageCertificates(int pageNumber) {
        logger.debug("MarriageCertificateServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<MarriageCertificate> pagedResult = marriageCertificateRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("MarriageCertificateServiceImpl::count");
        return marriageCertificateRepository.count();
    }

    @Transactional
    @Override
    public MarriageCertificateCommand saveMarriageCertificateCommand(MarriageCertificateCommand marriageCertificateCommand) {
        logger.debug("MarriageCertificateServiceImpl::saveMarriageCertificateCommand");
        MarriageCertificate marriageCertificate = marriageCertificateCommandConverterImpl.convert(marriageCertificateCommand);
        MarriageCertificate savedMarriageCertificate = marriageCertificateRepository.save(marriageCertificate);
        return marriageCertificateConverterImpl.convert(savedMarriageCertificate);

    }

    @Override
    public List<MarriageCertificate> findAll() {
        logger.debug("MarriageCertificateServiceImpl::findAll");
        List<MarriageCertificate> result = new ArrayList<>();
        Iterable<MarriageCertificate> marriageCertificateIterable = marriageCertificateRepository.findAll();
        marriageCertificateIterable.forEach(result::add);
        return result;
    }

}
