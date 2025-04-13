/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1744582103832-1
ALTER TABLE census_entry
    ADD `condition`  VARCHAR(255) NULL;

