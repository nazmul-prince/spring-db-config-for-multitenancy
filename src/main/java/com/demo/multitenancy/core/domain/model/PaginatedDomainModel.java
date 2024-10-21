package com.demo.multitenancy.core.domain.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PaginatedDomainModel {

    private int page;
    private int size;
    private int total;
    private List<?> domainModels;

}


