package com.demo.multitenancy.infradetails.persistence.mapper;

import com.demo.multitenancy.core.domain.model.usecase.Region;
import com.demo.multitenancy.infrastructure.model.requestresponse.RegionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegionDomainResponseMapper extends DomainResponseMapper<Region, RegionResponse> {

    RegionDomainResponseMapper INSTANCE = Mappers.getMapper(RegionDomainResponseMapper.class);

}