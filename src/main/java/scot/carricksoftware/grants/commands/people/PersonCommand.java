/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 02:05. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.people;

public interface PersonCommand {

    Long getId();

    void setId(Long id);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);
}
