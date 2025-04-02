/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.image;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.images.image.ImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.image.ImageConverterImpl;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.repositories.images.ImageRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    private static final Logger logger = LogManager.getLogger(ImageServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final ImageRepository imageRepository;
    private final ImageConverterImpl imageConverterImpl;
    private final ImageCommandConverterImpl imageCommandConverterImpl;

    public ImageServiceImpl(
            ImageRepository imageRepository,
            ImageConverterImpl imageConverterImpl,
            ImageCommandConverterImpl imageCommandConverterImpl) {

        this.imageRepository = imageRepository;
        this.imageConverterImpl = imageConverterImpl;
        this.imageCommandConverterImpl = imageCommandConverterImpl;
    }


    @Override
    public Image findById(Long id) {
        logger.debug("ImageServiceImpl::findById");
        Optional<Image> imageOptional = imageRepository.findById(id);
        return imageOptional.orElse(null);
    }


    public Image save(Image image) {
        logger.debug("ImageServiceImpl::save");
        return imageRepository.save(image);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("ImageServiceImpl::deleteBy");
        imageRepository.deleteById(id);
    }


    @Override
    public List<Image> getPagedImages(int pageNumber) {
        logger.debug("ImageServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<Image> pagedResult = imageRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("ImageServiceImpl::count");
        return imageRepository.count();
    }

    @Transactional
    @Override
    public ImageCommand saveImageCommand(ImageCommand imageCommand) {
        logger.debug("ImageServiceImpl::saveImageCommand");
        Image image = imageCommandConverterImpl.convert(imageCommand);
        Image savedImage = imageRepository.save(image);
        return imageConverterImpl.convert(savedImage);

    }

    @Override
    public List<Image> findAll() {
        logger.debug("ImageServiceImpl::findAll");
        List<Image> result = new ArrayList<>();
        Iterable<Image> imageIterable = imageRepository.findAll();
        imageIterable.forEach(result::add);
        return result;
    }

}
