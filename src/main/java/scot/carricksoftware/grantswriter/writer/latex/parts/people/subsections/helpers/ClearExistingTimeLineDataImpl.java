/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.TimeLineData;


@Component
public class ClearExistingTimeLineDataImpl implements ClearExistingTimeLineData {
     private final TimeLineData timeLineData;

     public ClearExistingTimeLineDataImpl(TimeLineData timeLineData) {
          this.timeLineData = timeLineData;
     }

     @Override
     public void clear() {
          timeLineData.clear();
     }

}
