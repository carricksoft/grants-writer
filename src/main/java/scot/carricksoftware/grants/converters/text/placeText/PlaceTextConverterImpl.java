/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 13:10. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.placeText;


import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.commands.text.PlaceTextCommandImpl;
import scot.carricksoftware.grants.domains.text.PlaceText;

@Component
public class PlaceTextConverterImpl implements PlaceTextConverter {
    private static final Logger logger = LogManager.getLogger(PlaceTextConverterImpl.class);

    @Override
    public PlaceTextCommand convert(@NotNull PlaceText source) {
        logger.debug("PlaceTextCommandConverter::convert");
        PlaceTextCommand target = new PlaceTextCommandImpl();
        target.setId(source.getId());
        target.setPlace(source.getPlace());
        return target;
    }


}
