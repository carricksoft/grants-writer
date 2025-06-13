/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class DateSortLinkedMultiValueMapImpl implements DateSortLinkedMultiValueMap {


    private static final Logger logger = LogManager.getLogger(DateSortLinkedMultiValueMapImpl.class);

    @Override
    public LinkedMultiValueMap<String, String> sort(LinkedMultiValueMap<String, String> map) {

        logger.debug("LinkedMultiValueMapImpl::sort");
        Set<String> keys = map.keySet();
        List<String> keyList = new ArrayList<>(keys);
        if (keyList.size() > 1) {
            sortKeyList(keyList);
        }
        LinkedMultiValueMap<String, String> newMap = new LinkedMultiValueMap<>();
        for (String key : keyList) {
            List<String> values = map.get(key);
            assert values != null;
            newMap.put(key, values);
        }
        return newMap;
    }

    @SuppressWarnings({"CommentedOutCode", "EmptyMethod", "unused"})
    private void sortKeyList(List<String> keyList) {
        //       int n = keyList.size();
        //      boolean swapped;
//        do {
//            swapped = false;
//            for (int i = 0; i < n - 1; i++) {
//                if (compareTo(keyList.get(i), keyList.get(i + 1)) > 0) {
//                    swapEntries(keyList, i + 1, i);
//                    swapped = true;
//                }
//            }
//        } while (swapped);

    }

    @Override
    public void swapEntries(List<String> keyList, int i, int j) {
        String temp = keyList.get(i);
        keyList.set(i, keyList.get(j));
        keyList.set(j, temp);
    }

    @Override
    public int compareDates(String a, String b) {
        String[] aParts = a.split("/");
        String[] bParts = b.split("/");
        if (Integer.parseInt(aParts[0]) > Integer.parseInt(bParts[0])) {
            return 1;
        }
        if (Integer.parseInt(aParts[1]) > Integer.parseInt(bParts[1])) {
            return 1;
        }
        if (Integer.parseInt(aParts[2]) > Integer.parseInt(bParts[2])) {
            return 1;
        }
        return 0;
    }
}

