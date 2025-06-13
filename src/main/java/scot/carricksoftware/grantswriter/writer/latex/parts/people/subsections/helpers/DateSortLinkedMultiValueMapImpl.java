/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Component
public class DateSortLinkedMultiValueMapImpl implements DateSortLinkedMultiValueMap {

    private static final Logger logger = LogManager.getLogger(DateSortLinkedMultiValueMapImpl.class);

    @Override
    public LinkedMultiValueMap<String, String> sort(LinkedMultiValueMap<String, String> map) {
        logger.info("DateSortLinkedMultiValueMapImpl::sort");
        LinkedHashMap<String, List<String>> tempMap = new LinkedHashMap<>();
        mapConvert(map, tempMap);
        dateSort(tempMap);
        deConvert(tempMap, map);
        return map;
    }

    private void deConvert(HashMap<String, List<String>> tempMap, LinkedMultiValueMap<String, String> map) {
        logger.info("DateSortLinkedMultiValueMapImpl::deConvert");
        Set<String> keys = tempMap.keySet();
        for (String key : keys) {
            map.put(key, Objects.requireNonNull(map.get(key)));
        }
    }

    private void mapConvert(LinkedMultiValueMap<String, String> map, LinkedHashMap<String, List<String>> tempMap) {
        Set<String> keys = map.keySet();
        for (String key : keys) {
            tempMap.put(key, map.get(key));
        }
    }

    @SuppressWarnings({"EmptyMethod", "unused"})
    private void dateSort(LinkedHashMap<String, List<String>> map) {
        logger.info("DateSortLinkedMultiValueMapImpl::dateSort");
    }




}

