/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.converters;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.DMYImpl;

@Component
public class StringToDMYConverterImpl implements StringToDMYConverter {

    @Override
    public DMY convert(String dateKey) {
        DMY dmyKey = new DMYImpl();
        dmyKey.parse(dateKey);
        return dmyKey;
    }
}
