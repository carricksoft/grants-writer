/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;

import scot.carricksoftware.grantswriter.combined.Combined;
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.combined.CombinedContentListImpl;
import scot.carricksoftware.grantswriter.combined.CombinedContentType;
import scot.carricksoftware.grantswriter.combined.CombinedImpl;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.text.PersonText;
import scot.carricksoftware.grantswriter.repositories.text.PersonTextRepository;

public class CombinedServiceImpl implements CombinedService {

    private final PersonTextRepository personTextRepository;

    public CombinedServiceImpl(PersonTextRepository personTextRepository) {
        this.personTextRepository = personTextRepository;
    }

    @Override
    public CombinedContentList getPersonContent(Person person) {
        CombinedContentList result = new CombinedContentListImpl();
        addText(person, result);
        return result;
    }

    private void addText(Person person, CombinedContentList result) {
        Iterable<PersonText> personIterable = personTextRepository.findAllByPerson(person);
        for (PersonText personText : personIterable) {
            Combined combined = new CombinedImpl();
            combined.setContentId(personText.getId());
            combined.setContentType(CombinedContentType.TEXT.label);
            result.addPersonText(personText);
        }
    }

}
