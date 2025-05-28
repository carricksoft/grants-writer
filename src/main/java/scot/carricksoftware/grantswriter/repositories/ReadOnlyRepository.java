/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.repositories;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ReadOnlyRepository<T, ID> extends Repository<T, ID> {

    @SuppressWarnings("unused")
    Optional<T> findById(ID id);
    @SuppressWarnings("unused")
    List<T> findAll();

}
