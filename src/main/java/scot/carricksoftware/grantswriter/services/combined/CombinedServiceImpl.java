/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.domains.people.Person;

@Service
public class CombinedServiceImpl implements CombinedService {

    private final CombinedPersonService combinedPersonService;

    public CombinedServiceImpl(CombinedPersonService combinedPersonService) {
        this.combinedPersonService = combinedPersonService;
    }

    @Override
    public CombinedContentList getPersonContent(Person person) {
        return combinedPersonService.getPersonContent(person);
    }

}
