/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 13:10. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.persontext;


import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.commands.text.PersonTextCommandImpl;
import scot.carricksoftware.grants.domains.text.PersonText;

@Component
public class PersonTextConverterImpl implements PersonTextConverter {

    private static final Logger logger = LogManager.getLogger(PersonTextConverterImpl.class);

    @Override
    public PersonTextCommand convert(@NotNull PersonText source) {
        logger.debug("PersonTextCommandConverter::convert");
        PersonTextCommand target = new PersonTextCommandImpl();
        target.setId(source.getId());
        target.setPerson(source.getPerson());
        return target;
    }


}
