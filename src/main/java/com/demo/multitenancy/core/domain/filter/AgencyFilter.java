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
public class AgencyFilter {

    private Integer regionId;
    private Integer zillaId;
    private Integer upazilaId;
    private Integer municipalityId;
    private Integer unionOrWardId;
    private Integer agencyTypeId;
    private List<Integer> agencyTypeIds;
    private String nameBn;
    private String nameEn;
    private String email;
    private String mobileNo;
    private List<Integer> agencyIds;
    private Boolean isActive;

}
