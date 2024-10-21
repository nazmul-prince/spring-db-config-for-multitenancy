package com.demo.multitenancy.core.domain.filter;

import com.demo.multitenancy.core.constant.QueryCondition;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UnionOrWardFilter {

    private Integer unionOrWardCode;
    private Integer upazilaId;
    private List<Integer> upazilaIds;
    private Integer regionId;
    private Integer zillaId;
    private Integer municipalityId;
    private Integer constituencyId;
    private String rmo;
    private String nameBn;
    private String nameEn;
    private List<Integer> unionOrWardIds;
    private List<Integer> municipalityWardIds;
    private List<Integer> reservedWardIds;
    private QueryCondition queryCondition;

}
