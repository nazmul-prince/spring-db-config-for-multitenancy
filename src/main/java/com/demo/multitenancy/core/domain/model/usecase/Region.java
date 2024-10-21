package com.demo.multitenancy.core.domain.model.usecase;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Region {

    private Integer id;
    private Integer regionCode;
    private String nameBn;
    private String nameEn;
    private Boolean isActive;
    private String geoCode;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
