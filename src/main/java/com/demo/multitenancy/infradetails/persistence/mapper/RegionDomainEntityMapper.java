package com.demo.multitenancy.infradetails.persistence.mapper;

import com.demo.multitenancy.core.domain.model.usecase.Region;
import com.demo.multitenancy.infradetails.persistence.entity.RegionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel =
        MappingConstants.ComponentModel.SPRING)
public interface RegionDomainEntityMapper extends DomainEntityMapper<Region, RegionEntity> {
}