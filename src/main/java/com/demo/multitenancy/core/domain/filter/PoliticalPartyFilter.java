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
public class PoliticalPartyFilter {

    private String nameEn;
    private String nameBn;
    private String address;
    private Integer regNo;
    private List<Integer> politicalPartyIds;
    private Boolean isActive;
    private Boolean isPolitical;

}
