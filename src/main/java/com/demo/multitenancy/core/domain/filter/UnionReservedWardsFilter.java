package com.demo.multitenancy.core.domain.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UnionReservedWardsFilter {

    private Integer id;
    private Integer regionId;
    private Integer zillaId;
    private Integer upazilaId;
    private Integer unionId;
    private Integer code;
    private String nameBn;
    private String nameEn;

}
