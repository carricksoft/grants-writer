/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.places.regions;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.repositories.places.RegionRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;


@ExtendWith(MockitoExtension.class)
public class RegionServiceTest {

    RegionService regionService;

    @Mock
    RegionRepository regionRepositoryMock;

    @Mock
    RegionConverterImpl regionConverterImplMock;

    @Mock
    RegionCommandConverterImpl regionCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        regionService = new RegionServiceImpl(regionRepositoryMock,
                regionConverterImplMock,
                regionCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @Mock
    Page<Region> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        regionService.deleteById(id);
        verify(regionRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(regionRepositoryMock.count()).thenReturn(result);
        assertEquals(result, regionService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<Region> result = new ArrayList<>();
        Region region = GetRandomRegion();
        result.add(region);
        when(pageMock.getContent()).thenReturn(result);
        when(regionRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, regionService.getPagedRegions(0));
    }


}