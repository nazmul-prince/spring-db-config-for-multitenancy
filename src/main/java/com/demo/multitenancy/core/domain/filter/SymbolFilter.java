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
public class SymbolFilter {

    private String nameEn;
    private String nameBn;
    private Integer politicalPartyId;
    private List<Integer> symbolIds;
    private Boolean isActive;
    private Boolean isPolitical;
    private Integer candidateTypeId;

}
