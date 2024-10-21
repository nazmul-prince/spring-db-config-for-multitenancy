package com.demo.multitenancy.core.domain.usecase.regionusecase;

import com.demo.multitenancy.core.domain.model.usecase.Region;
import com.demo.multitenancy.core.domain.filter.RegionFilter;
import com.demo.multitenancy.core.domain.model.PaginatedDomainModel;
import com.demo.multitenancy.core.domain.model.PaginationModel;
import com.demo.multitenancy.core.shared.exceptions.DataNotFoundException;


public interface RegionRetrieveUseCase {

    PaginatedDomainModel getRegions(RegionFilter regionFilter, PaginationModel paginationModel);

    Region getRegionById(Integer id) throws DataNotFoundException;

}
