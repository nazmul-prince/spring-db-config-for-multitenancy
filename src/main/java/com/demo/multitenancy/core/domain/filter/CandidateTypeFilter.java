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
public class CandidateTypeFilter {

    private Integer id;
    private String nameBn;
    private String nameEn;
    private Integer priorityLevel;
    private Integer electionTypeId;
    private Integer jamanatAmount;
    private List<Integer> candidateTypeIds;

}
