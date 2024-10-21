package com.demo.multitenancy.core.domain.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PollingInstituteFilter {

    private Integer regionId;
    private Integer zillaId;
    private Integer upazilaId;
    private Integer municipalityId;
    private Integer unionOrWardId;
    private Integer reservedWardId;
    private Integer instituteTypeId;
    private Integer buildingTypeId;
    private String nameBn;
    private String nameEn;
    private String addressBn;
    private String addressEn;
    private String headName;
    private String headContactNo;
    private Integer noOfEmployee;
    private Integer noOfFloor;
    private Integer noOfRoom;
    private Boolean hasLatitude;

}
