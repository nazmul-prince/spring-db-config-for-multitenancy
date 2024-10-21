package com.demo.multitenancy.infradetails.persistence.mapper;

import com.demo.multitenancy.core.domain.model.usecase.Region;
import com.demo.multitenancy.infrastructure.model.requestresponse.RegionListResponse;
import com.demo.multitenancy.infrastructure.model.requestresponse.RegionResponse;
import com.demo.multitenancy.core.domain.model.PaginatedDomainModel;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegionListResponseMapper extends
        DomainResponseMapper<PaginatedDomainModel, RegionListResponse> {

    RegionListResponseMapper INSTANCE = Mappers.getMapper(RegionListResponseMapper.class);

    @Override
    @Mapping(target = "regions", source = "domainModels", qualifiedByName =
            "domainModelToRegionListResponse")
    RegionListResponse domainModelToResponseModel(PaginatedDomainModel domainModel);

    @Named("domainModelToRegionListResponse")
    default List<RegionResponse> domainModelToRegionListResponse(List<?> domainModels) {
        return domainModels.stream()
                .map(object -> RegionDomainResponseMapper.INSTANCE.domainModelToResponseModel(
                        (Region) object))
                .toList();
    }

}