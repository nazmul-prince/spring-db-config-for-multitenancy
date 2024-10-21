package com.demo.multitenancy.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PaginationModel {

    private Integer page;
    private Integer size;

}
