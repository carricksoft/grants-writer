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
import scot.carricksoftware.grants.domains.text.PersonText;

@Component
public class PersonTextCommandConverterImpl implements PersonTextCommandConverter {

    private static final Logger logger = LogManager.getLogger(PersonTextCommandConverterImpl.class);

    @Override
    public PersonText convert(@NotNull PersonTextCommand source) {
        logger.debug("PersonTextCommandConverter::convert");
        PersonText target = new PersonText();
        target.setId(source.getId());
        target.setPerson(source.getPerson());
        return target;
    }


}
