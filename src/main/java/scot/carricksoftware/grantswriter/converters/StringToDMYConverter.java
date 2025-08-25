/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.converters;

import scot.carricksoftware.grantswriter.data.DMY;

public interface StringToDMYConverter {
    DMY convert(String dateKey);
}
