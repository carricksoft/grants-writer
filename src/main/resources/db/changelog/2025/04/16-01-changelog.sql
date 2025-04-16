/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1744789012725-1
ALTER TABLE census_entry
    ADD worker       VARCHAR(255) NULL;

