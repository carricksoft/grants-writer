/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class StatusServiceImpl implements StatusService {

    private static final Logger logger = LogManager.getLogger(StatusServiceImpl.class);

    private final LinkedHashMap<String, String> status = new LinkedHashMap<>();

    @Override
    public LinkedHashMap<String, String> getStatus() {
        logger.info("StatusService::getStatus");

        status.put("People", "0");
        status.put("Birth Certificates", "0");
        status.put("Marriage Certificates", "0");
        status.put("Divorce Certificates", "0");
        status.put("Death Certificates", "0");
        status.put("", "");
        status.put("Censuses", "0");
        status.put("Census Entries", "0");
        return status;
    }
}
