/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.services.text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.domains.text.AppendixText;
import scot.carricksoftware.grantswriter.repositories.text.AppendixTextRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppendixTextServiceImpl extends TextServiceImpl implements AppendixTextService {
    private static final Logger logger = LogManager.getLogger(AppendixTextServiceImpl.class);

    private final AppendixTextRepository appendixTextRepository;

    public AppendixTextServiceImpl(AppendixTextRepository appendixTextRepository) {
        this.appendixTextRepository = appendixTextRepository;
    }

    @Override
    public List<AppendixText> findAll() {
        logger.debug("AppendixTextServiceImpl::findAll");
        List<AppendixText> result = new ArrayList<>();
        Iterable<AppendixText> appendixTextIterable = appendixTextRepository.findAll();
        appendixTextIterable.forEach(result::add);
        return result;
    }

    @Override
    public AppendixText findById(Long id) {
        return appendixTextRepository.findById(id);
    }

}
