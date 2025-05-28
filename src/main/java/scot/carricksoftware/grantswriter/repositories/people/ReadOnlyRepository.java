/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.repositories.people;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;

@NoRepositoryBean
public interface ReadOnlyRepository<T, ID> extends Repository<T, ID> {

    List<T> findAll();
}
