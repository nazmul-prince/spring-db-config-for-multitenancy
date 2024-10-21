package com.demo.multitenancy.core.domain.persistence.port;

import com.demo.multitenancy.core.domain.model.usecase.Region;
import com.demo.multitenancy.core.domain.model.PaginatedDomainModel;
import com.demo.multitenancy.core.domain.model.PaginationModel;
import com.demo.multitenancy.core.domain.filter.RegionFilter;

import java.util.List;

public interface RegionPersistencePort {

    PaginatedDomainModel getRegions(RegionFilter regionFilter, PaginationModel paginationModel);

    Region getRegionById(Integer id);

    Region createRegion(Region region);

    Region updateRegion(Integer id, Region region);

    void deleteRegionById(Integer id);

    List<Region> getAllRegions();
}
