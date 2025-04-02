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
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.repositories.places.RegionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;

@ExtendWith(MockitoExtension.class)
public class RegionServiceFindTest {

    RegionService regionService;

    @Mock
    RegionRepository regionRepositoryMock;

    @Mock
    RegionConverterImpl regionConverterMock;

    @Mock
    RegionCommandConverterImpl regionCommandConverterMock;

    @BeforeEach
    public void setUp() {
        regionService = new RegionServiceImpl(regionRepositoryMock,
                regionConverterMock,
                regionCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<Region> countries = new ArrayList<>();
        countries.add(GetRandomRegion());
        when(regionRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, regionService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        Region region = GetRandomRegion();
        Optional<Region> regionOptional = Optional.of(region);
        when(regionRepositoryMock.findById(id)).thenReturn(regionOptional);
        assertEquals(region, regionService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<Region> empty = Optional.empty();
        when(regionRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(regionService.findById(id));
    }

}