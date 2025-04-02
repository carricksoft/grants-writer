/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:06. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.people;

import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.domains.people.Person;

@SuppressWarnings("NullableProblems")
public interface PersonConverter extends Converter<Person, PersonCommand> {
    PersonCommand convert(Person person);
}
