/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.SortedMap;
import java.util.TreeMap;

@Service
public class StatusServiceImpl implements StatusService {

    private static final Logger logger = LogManager.getLogger(StatusServiceImpl.class);


    @Override
    public SortedMap<String, String> getStatus() {
        logger.info("StatusServiceImpl::getStatus");
        return new TreeMap<>();
    }
}
