package com.demo.multitenancy.core.constant;

import lombok.Getter;

@Getter
public enum QueryOperator {

    GREATER_THAN_EQUALS,
    LESS_THAN_EQUALS,
    RANGE,
    EQUALS,
    LIKE,
    LIKE_JOIN,
    NOT_EQUALS,
    IN,
    JOIN,
    MULTI_JOIN,
    IN_JOIN,
    MULTI_JOIN_IN,
    IS_NULL,
    IS_NOT_NULL,
    LEFT_JOIN_IN
}
