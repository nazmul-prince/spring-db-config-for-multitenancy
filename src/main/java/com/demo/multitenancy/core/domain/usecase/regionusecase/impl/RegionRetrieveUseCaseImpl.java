package com.demo.multitenancy.core.domain.usecase.regionusecase.impl;

import com.demo.multitenancy.core.domain.model.usecase.Region;
import com.demo.multitenancy.core.domain.usecase.regionusecase.RegionRetrieveUseCase;
import com.demo.multitenancy.core.constant.HttpStatusCode;
import com.demo.multitenancy.core.custom.annotation.transactional.Transactional;
import com.demo.multitenancy.core.domain.filter.RegionFilter;
import com.demo.multitenancy.core.domain.model.PaginatedDomainModel;
import com.demo.multitenancy.core.domain.model.PaginationModel;
import com.demo.multitenancy.core.domain.persistence.port.RegionPersistencePort;
import com.demo.multitenancy.core.shared.exceptions.DataNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional(readOnly = true)
public class RegionRetrieveUseCaseImpl implements RegionRetrieveUseCase {

    private final RegionPersistencePort regionPersistencePort;

    @Override
    public PaginatedDomainModel getRegions(
            RegionFilter regionFilter, PaginationModel paginationModel
    ) {
        return regionPersistencePort.getRegions(regionFilter, paginationModel);
    }

    @Override
    public Region getRegionById(Integer id) throws DataNotFoundException {
        Region foundRegion = regionPersistencePort.getRegionById(id);

        if (foundRegion == null) {
            throw new DataNotFoundException(
                    "Region not found with Id: " + id, HttpStatusCode.NOT_FOUND);
        }

        return foundRegion;
    }

}
