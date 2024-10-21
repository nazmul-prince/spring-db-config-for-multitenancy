package com.demo.multitenancy.core.domain.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ConstituencyLocationMappingFilter {

    private Integer regionId;
    private Integer zillaId;
    private Integer constituencyId;
    private Integer unionOrWardId;
    private Boolean isActive;

}
