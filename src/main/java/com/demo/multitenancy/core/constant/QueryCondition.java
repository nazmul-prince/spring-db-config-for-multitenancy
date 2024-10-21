package com.demo.multitenancy.core.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum QueryCondition {

    AND("AND"),
    OR("OR");

    private final String queryConditionValue;
}
