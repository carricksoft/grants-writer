/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.combined.CombinedContentListImpl;
import scot.carricksoftware.grantswriter.domains.images.AppendixImage;
import scot.carricksoftware.grantswriter.domains.text.AppendixText;
import scot.carricksoftware.grantswriter.repositories.images.AppendixImageRepository;
import scot.carricksoftware.grantswriter.repositories.text.AppendixTextRepository;

@Service
public class CombinedAppendixServiceImpl implements CombinedAppendixService {

    private final AppendixTextRepository appendixTextRepository;
    private final AppendixImageRepository appendixImageRepository;

    public CombinedAppendixServiceImpl(AppendixTextRepository appendixTextRepository, AppendixImageRepository appendixImageRepository) {
        this.appendixTextRepository = appendixTextRepository;
        this.appendixImageRepository = appendixImageRepository;
    }

    @Override
    public CombinedContentList getAppendixContent() {
        CombinedContentList result = new CombinedContentListImpl();
        addAppendixText(result);
        addAppendixImage(result);
        result.sort();
        return result;
    }

    private void addAppendixText(CombinedContentList result) {
        Iterable<AppendixText> appendixIterable = appendixTextRepository.findAll();
        for (AppendixText appendixText : appendixIterable) {
            result.addBaseText(appendixText);
        }
    }

    private void addAppendixImage(CombinedContentList result) {
        Iterable<AppendixImage> appendixImageIterable = appendixImageRepository.findAll();
        for (AppendixImage appendixImage : appendixImageIterable) {
            result.addBaseImage(appendixImage);
        }
    }

}
