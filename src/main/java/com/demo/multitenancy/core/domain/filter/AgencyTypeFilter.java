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
public class AgencyTypeFilter {

    private String nameBn;
    private String nameEn;
    private final List<Integer> agencyTypeIds;

}
