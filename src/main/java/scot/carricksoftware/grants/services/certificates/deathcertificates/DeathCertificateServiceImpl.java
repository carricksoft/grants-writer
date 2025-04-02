/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:53. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.certificates.deathcertificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.repositories.certificates.DeathCertificateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeathCertificateServiceImpl implements DeathCertificateService {
    private static final Logger logger = LogManager.getLogger(DeathCertificateServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final DeathCertificateRepository deathCertificateRepository;
    private final DeathCertificateConverterImpl deathCertificateConverterImpl;
    private final DeathCertificateCommandConverterImpl deathCertificateCommandConverterImpl;

    public DeathCertificateServiceImpl(
            DeathCertificateRepository deathCertificateRepository,
            DeathCertificateConverterImpl deathCertificateConverterImpl,
            DeathCertificateCommandConverterImpl deathCertificateCommandConverterImpl) {

        this.deathCertificateRepository = deathCertificateRepository;
        this.deathCertificateConverterImpl = deathCertificateConverterImpl;
        this.deathCertificateCommandConverterImpl = deathCertificateCommandConverterImpl;
    }


    @Override
    public DeathCertificate findById(Long id) {
        logger.debug("DeathCertificateServiceImpl::findById");
        Optional<DeathCertificate> deathCertificate = deathCertificateRepository.findById(id);
        return deathCertificate.orElse(null);
    }

    @Override
    public DeathCertificate save(DeathCertificate deathCertificate) {
        logger.debug("DeathCertificateServiceImpl::save");
        return deathCertificateRepository.save(deathCertificate);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("DeathCertificateServiceImpl::deleteBy");
        deathCertificateRepository.deleteById(id);
    }


    @Override
    public List<DeathCertificate> getPagedDeathCertificates(int pageNumber) {
        logger.debug("DeathCertificateServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<DeathCertificate> pagedResult = deathCertificateRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("DeathCertificateServiceImpl::count");
        return deathCertificateRepository.count();
    }

    @Transactional
    @Override
    public DeathCertificateCommand saveDeathCertificateCommand(DeathCertificateCommand deathCertificateCommand) {
        logger.debug("DeathCertificateServiceImpl::saveDeathCertificateCommand");
        DeathCertificate deathCertificate = deathCertificateCommandConverterImpl.convert(deathCertificateCommand);
        DeathCertificate savedDeathCertificate = deathCertificateRepository.save(deathCertificate);
        return deathCertificateConverterImpl.convert(savedDeathCertificate);

    }

    @Override
    public List<DeathCertificate> findAll() {
        logger.debug("DeathCertificateServiceImpl::findAll");
        List<DeathCertificate> result = new ArrayList<>();
        Iterable<DeathCertificate> deathCertificateIterable = deathCertificateRepository.findAll();
        deathCertificateIterable.forEach(result::add);
        return result;
    }

}
