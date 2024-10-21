package com.demo.multitenancy.core.domain.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UnionWardFilter {

    private Integer unionWardCode;
    private Integer upazilaId;
    private Integer unionId;
    private String nameBn;
    private String nameEn;
    private Integer unionWardId;
    private List<Integer> unionIds;
    private List<Integer> unionWardIds;

}
