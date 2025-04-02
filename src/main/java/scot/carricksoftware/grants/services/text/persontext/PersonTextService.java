/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 12:33. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.text.persontext;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.domains.text.PersonText;

import java.util.List;


@Service
public interface PersonTextService {

    @SuppressWarnings("unused")
    PersonText findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    PersonText save(PersonText personText);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<PersonText> getPagedPersonTexts(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    PersonTextCommand savePersonTextCommand(PersonTextCommand personTextCommand);

    @SuppressWarnings("unused")
    List<PersonText> findAll();
}
