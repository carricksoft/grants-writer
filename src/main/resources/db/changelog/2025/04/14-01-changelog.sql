/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1744644236906-1
ALTER TABLE census_entry
    ADD gaelic       VARCHAR(255) NULL;


