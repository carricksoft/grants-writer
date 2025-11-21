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
    private final CombinedAppendixService combinedAppendixService;
    private final CombinedDocumentService combinedDocumentService;

    public CombinedServiceImpl(CombinedPersonService combinedPersonService, CombinedAppendixService combinedAppendixService, CombinedDocumentService combinedDocumentService) {
        this.combinedPersonService = combinedPersonService;
        this.combinedAppendixService = combinedAppendixService;
        this.combinedDocumentService = combinedDocumentService;
    }

    @Override
    public CombinedContentList getPersonContent(Person person) {
        return combinedPersonService.getPersonContent(person);
    }

    @Override
    public CombinedContentList getAppendixContent() {
        return combinedAppendixService.getAppendixContent();
    }


    @Override
    public CombinedContentList getDocumentContent() {
        return combinedDocumentService.getDocumentContent();
    }
}
