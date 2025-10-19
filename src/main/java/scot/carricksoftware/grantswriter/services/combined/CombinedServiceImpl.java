/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.combined.CombinedContentListImpl;
import scot.carricksoftware.grantswriter.domains.images.PersonImage;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.text.PersonText;
import scot.carricksoftware.grantswriter.repositories.images.PersonImageRepository;
import scot.carricksoftware.grantswriter.repositories.text.PersonTextRepository;

@Service
public class CombinedServiceImpl implements CombinedService {

    private final PersonTextRepository personTextRepository;
    private final PersonImageRepository personImageRepository;

    public CombinedServiceImpl(PersonTextRepository personTextRepository,
                               PersonImageRepository personImageRepository) {
        this.personTextRepository = personTextRepository;
        this.personImageRepository = personImageRepository;
    }

    @Override
    public CombinedContentList getPersonContent(Person person) {
        CombinedContentList result = new CombinedContentListImpl();
        addPersonText(person, result);
        addPersonImage(person, result);
        result.sort();
        return result;
    }

    private void addPersonText(Person person, CombinedContentList result) {
        Iterable<PersonText> personIterable = personTextRepository.findAllByPerson(person);
        for (PersonText personText : personIterable) {
            result.addPersonText(personText);
        }
    }

    private void addPersonImage(Person person, CombinedContentList result) {
        Iterable<PersonImage> personImageIterable = personImageRepository.findAllByPerson(person);
        for (PersonImage personImage : personImageIterable) {
            result.addPersonImage(personImage);
        }
    }

}
