-- liquibase formatted sql
-- changeset zuhaimi:1677359372272-1
CREATE TABLE `groups` (
    id BIGINT,
    description VARCHAR(500),
    name VARCHAR(100),
    CONSTRAINT`groupsPK` PRIMARY KEY (id)
);

-- changeset zuhaimi:1677359372272-2
ALTER TABLE
    `groups`
ADD
    CONSTRAINT UC_GROUPSDESCRIPTION_COL UNIQUE (description);

-- changeset zuhaimi:1677359372272-3
ALTER TABLE
    `groups`
ADD
    CONSTRAINT UC_GROUPSNAME_COL UNIQUE (name);