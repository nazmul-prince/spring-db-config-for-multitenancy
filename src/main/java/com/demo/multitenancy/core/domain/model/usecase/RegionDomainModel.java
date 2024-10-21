package com.demo.multitenancy.core.domain.model.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegionDomainModel {

    private Integer regionId;
    private String nameEn;
    private String nameBn;
}
