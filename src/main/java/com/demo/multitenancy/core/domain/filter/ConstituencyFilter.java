package com.demo.multitenancy.core.domain.filter;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ConstituencyFilter {

    private String nameBn;
    private String nameEn;
    private Integer regionId;
    private Integer zillaId;
    private Boolean isActive;
    private String code;
    private List<Integer> constituencyIds;

}
