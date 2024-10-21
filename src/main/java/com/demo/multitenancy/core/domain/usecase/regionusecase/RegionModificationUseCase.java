package com.demo.multitenancy.core.domain.usecase.regionusecase;

import com.demo.multitenancy.core.domain.model.usecase.Region;
import com.demo.multitenancy.core.shared.exceptions.DataNotFoundException;

public interface RegionModificationUseCase {

    Region createRegion(Region region) throws DataNotFoundException;

    Region updateRegion(Integer id, Region region) throws DataNotFoundException;

    void deleteRegion(Integer id) throws DataNotFoundException;

}
