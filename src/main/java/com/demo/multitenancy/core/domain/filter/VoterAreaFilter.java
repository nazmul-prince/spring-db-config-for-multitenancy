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
public class VoterAreaFilter {

    private Integer zillaId;
    private Integer upazilaId;
    private Integer municipalityId;
    private Integer unionOrWardId;
    private String areaCode;
    private String electionClass;
    private String nameEn;
    private String nameBn;
    private Integer maleVoter;
    private Integer femaleVoter;
    private List<Integer> voterAreaIds;
    private List<Integer> unionOrWardIds;
    private List<Integer> unionWardIds;
}
