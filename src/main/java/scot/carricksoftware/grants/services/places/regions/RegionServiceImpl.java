/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.places.regions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.repositories.places.RegionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {

    private static final Logger logger = LogManager.getLogger(RegionServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final RegionRepository regionRepository;
    private final RegionConverterImpl regionConverterImpl;
    private final RegionCommandConverterImpl regionCommandConverterImpl;

    public RegionServiceImpl(
            RegionRepository regionRepository,
            RegionConverterImpl regionConverterImpl,
            RegionCommandConverterImpl regionCommandConverterImpl) {

        this.regionRepository = regionRepository;
        this.regionConverterImpl = regionConverterImpl;
        this.regionCommandConverterImpl = regionCommandConverterImpl;
    }


    @Override
    public Region findById(Long id) {
        logger.debug("RegionServiceImpl::findById");
        Optional<Region> region = regionRepository.findById(id);
        return region.orElse(null);
    }

    @Override
    public Region save(Region region) {
        logger.debug("RegionServiceImpl::save");
        return regionRepository.save(region);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("RegionServiceImpl::deleteBy");
        regionRepository.deleteById(id);
    }


    @Override
    public List<Region> getPagedRegions(int pageNumber) {
        logger.debug("RegionServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<Region> pagedResult = regionRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "name");
    }

    @Override
    public long count() {
        logger.debug("RegionServiceImpl::count");
        return regionRepository.count();
    }

    @Transactional
    @Override
    public RegionCommand saveRegionCommand(RegionCommand regionCommand) {
        logger.debug("RegionServiceImpl::saveRegionCommand");
        Region region = regionCommandConverterImpl.convert(regionCommand);
        Region savedRegion = regionRepository.save(region);
        return regionConverterImpl.convert(savedRegion);

    }

    @Override
    public List<Region> findAll() {
        logger.debug("RegionServiceImpl::findAll");
        List<Region> result = new ArrayList<>();
        Iterable<Region> regionIterable = regionRepository.findAll();
        regionIterable.forEach(result::add);
        return result;
    }

}
