/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:17. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.people;

import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.domains.people.Person;

@SuppressWarnings("NullableProblems")
public interface PersonCommandConverter extends Converter<PersonCommand, Person> {

    Person convert(PersonCommand personCommand);
}
