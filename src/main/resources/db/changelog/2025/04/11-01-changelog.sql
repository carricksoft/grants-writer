/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1744362868561-1
ALTER TABLE census_entry
    ADD relationship VARCHAR(255) NULL;

