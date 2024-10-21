package com.demo.multitenancy.core.domain.filter;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegionFilter {

    private Integer regionCode;
    private String nameBn;
    private String nameEn;
    private List<Integer> regionIds;

    public String c() {
        return "RegionFilter [regionCode=" + regionCode + ", nameBn=" + nameBn + ", nameEn="
                + nameEn + ", regionIds=" + regionIds + "]";
    }

}
