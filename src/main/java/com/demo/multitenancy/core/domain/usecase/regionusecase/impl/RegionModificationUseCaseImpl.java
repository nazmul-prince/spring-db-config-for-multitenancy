package com.demo.multitenancy.core.domain.usecase.regionusecase.impl;

import com.demo.multitenancy.core.domain.model.usecase.Region;
import com.demo.multitenancy.core.domain.usecase.regionusecase.RegionModificationUseCase;
import com.demo.multitenancy.core.constant.HttpStatusCode;
import com.demo.multitenancy.core.custom.annotation.transactional.Transactional;
import com.demo.multitenancy.core.domain.persistence.port.RegionPersistencePort;
import com.demo.multitenancy.core.shared.exceptions.DataNotFoundException;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Transactional()
public class RegionModificationUseCaseImpl implements RegionModificationUseCase {

    private final RegionPersistencePort regionPersistencePort;

    @Override
    public Region createRegion(Region region) throws DataNotFoundException {
        Region newlyCreatedRegion = regionPersistencePort.createRegion(region);

        if (region == null) {
            throw new DataNotFoundException(
                    "Could not create new region", HttpStatusCode.NOT_FOUND);
        }

        return newlyCreatedRegion;
    }

    @Override
    public Region updateRegion(Integer id, Region region) throws DataNotFoundException {
        Region updatedRegion = regionPersistencePort.updateRegion(id, region);

        if (updatedRegion == null) {
            throw new DataNotFoundException(
                    "Could not find region with id: " + id, HttpStatusCode.NOT_FOUND);
        }

        return updatedRegion;
    }

    @Override
    public void deleteRegion(Integer id) throws DataNotFoundException {
        Region region = regionPersistencePort.getRegionById(id);
        if (region == null) {
            throw new DataNotFoundException(
                    "Could not find region with id: " + id, HttpStatusCode.NOT_FOUND);
        }

        regionPersistencePort.deleteRegionById(id);
    }

}
