package com.demo.multitenancy.core.domain.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BuildingTypeFilter {

    private String nameBn;
    private String nameEn;

}
