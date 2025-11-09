/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.image;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.domains.images.AppendixImage;
import scot.carricksoftware.grantswriter.repositories.images.AppendixImageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppendixImageServiceImpl implements AppendixImageService {

    private static final Logger logger = LogManager.getLogger(AppendixImageServiceImpl.class);

    private final AppendixImageRepository appendixImageRepository;

    public AppendixImageServiceImpl(AppendixImageRepository appendixImageRepository) {
        this.appendixImageRepository = appendixImageRepository;
    }

    @Override
    public List<AppendixImage> findAll() {
        logger.debug("AppendixServiceImpl::findAllByPerson");
        List<AppendixImage> result = new ArrayList<>();
        Iterable<AppendixImage> appendixImageIterable = appendixImageRepository.findAll();
        for (AppendixImage appendixImage : appendixImageIterable) {
            result.add(appendixImage);
        }
        return result;
    }

    @Override
    public AppendixImage findById(Long id) {
        return appendixImageRepository.findById(id);
    }
}
