/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;

import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.combined.CombinedContentListImpl;
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
        Iterable<PersonText> personIterable = personTextRepository.findAllByPerson(person);
        for (PersonText personText : personIterable) {
            result.addPersonText(personText);
        }
        return result;
    }


}
