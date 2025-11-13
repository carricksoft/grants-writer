/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.domains.images.AppendixImage;
import scot.carricksoftware.grantswriter.domains.text.AppendixText;
import scot.carricksoftware.grantswriter.repositories.images.AppendixImageRepository;
import scot.carricksoftware.grantswriter.repositories.text.AppendixTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
class CombinedAppendixServiceSortTest {

    private CombinedAppendixService service;

    @Mock
    AppendixTextRepository appendixTextRepositoryMock;

    @Mock
    AppendixImageRepository appendixImageRepositoryMock;

    private List<AppendixText> appendixTextList;
    private List<AppendixImage> appendixImageList;
    private final Long Id = GetRandomLong();
    private final AppendixText appendixText = new AppendixText();
    private final AppendixImage appendixImage = new AppendixImage();

    @BeforeEach
    void setUp() {
        service = new CombinedAppendixServiceImpl(appendixTextRepositoryMock, appendixImageRepositoryMock);
        appendixTextList = new ArrayList<>();
        appendixImageList = new ArrayList<>();
    }

    @Test
    void sortingWorksTest() {
        String highOrder = "99";
        appendixText.setOrder(highOrder);
        appendixText.setId(Id);
        appendixTextList.add(appendixText);
        when(appendixTextRepositoryMock.findAll()).thenReturn(appendixTextList);

        String lowOrder = "1";
        appendixImage.setOrder(lowOrder);
        appendixImage.setId(Id);
        appendixImageList.add(appendixImage);
        when(appendixImageRepositoryMock.findAll()).thenReturn(appendixImageList);
        CombinedContentList combinedContentList = service.getAppendixContent();

        assertEquals(lowOrder, combinedContentList.getList().get(0).getOrder());
        assertEquals(highOrder, combinedContentList.getList().get(1).getOrder());
    }


}