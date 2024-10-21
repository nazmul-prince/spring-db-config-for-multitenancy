package com.demo.multitenancy.infradetails.persistence.mapper;

import com.demo.multitenancy.core.domain.model.usecase.Region;
import com.demo.multitenancy.infrastructure.model.requestresponse.RegionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegionDomainRequestMapper extends DomainRequestMapper<Region, RegionRequest> {

    RegionDomainRequestMapper INSTANCE = Mappers.getMapper(RegionDomainRequestMapper.class);

}