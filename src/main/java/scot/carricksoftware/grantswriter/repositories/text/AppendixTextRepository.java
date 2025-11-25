/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.text;

import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.text.AppendixText;
import scot.carricksoftware.grantswriter.repositories.ReadOnlyRepository;

@Repository
public interface AppendixTextRepository extends ReadOnlyRepository<AppendixText, Long> {

    Iterable<AppendixText> findAll();
    AppendixText findById(Long id);
}
