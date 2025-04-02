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
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.commands.places.regions.RegionCommandImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.repositories.places.RegionRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;


@ExtendWith(MockitoExtension.class)
public class RegionServiceSaveTest {

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


    @Test
    public void saveTest() {
        Region region = new Region();
        region.setName(GetRandomString());

        when(regionRepositoryMock.save(region)).thenReturn(region);

        assertEquals(region, regionService.save(region));
    }

    @Test
    public void saveRegionCommandTest() {
        Region region = GetRandomRegion();
        RegionCommand regionCommand = new RegionCommandImpl();
        when(regionCommandConverterImplMock.convert(regionCommand)).thenReturn(region);
        when(regionRepositoryMock.save(region)).thenReturn(region);
        when(regionConverterImplMock.convert((region))).thenReturn(regionCommand);

        assertEquals(regionCommand, regionService.saveRegionCommand(regionCommand));
    }


}