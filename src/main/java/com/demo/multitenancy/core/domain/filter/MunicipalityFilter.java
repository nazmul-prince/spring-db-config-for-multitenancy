package com.demo.multitenancy.core.domain.filter;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class MunicipalityFilter {

    private Integer municipalityCode;
    private Integer zillaId;
    private Integer upazilaId;
    private Integer regionId;
    private String rmo;
    private String nameBn;
    private String nameEn;
    private List<Integer> municipalityIds;

}
