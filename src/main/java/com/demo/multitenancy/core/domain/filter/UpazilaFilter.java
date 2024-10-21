package com.demo.multitenancy.core.domain.filter;

import com.demo.multitenancy.core.constant.QueryCondition;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UpazilaFilter {

    private Integer upazilaCode;
    private Integer zillaId;
    private Integer regionId;
    private Integer municipalityId;
    private String nameBn;
    private String nameEn;
    private List<Integer> upazilaIds;
    private List<Integer> municipalityIds;
    private List<Integer> constituencyIds;
    private List<Integer> municipalityWardIds;
    private List<Integer> reservedWardIds;
    private QueryCondition queryCondition;
    private Boolean isThana;

}
