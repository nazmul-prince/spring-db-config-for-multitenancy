package com.demo.multitenancy.core.domain.filter;

import com.demo.multitenancy.core.constant.QueryCondition;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReservedWardFilter {

    private Integer code;
    private Integer upazilaId;
    private Integer municipalityId;
    private String rmo;
    private String nameBn;
    private String nameEn;
    private List<Integer> reservedWardIds;
    private List<Integer> municipalityWardIds;
    private List<Integer> unionOrWardIds;
    private QueryCondition queryCondition;

}
