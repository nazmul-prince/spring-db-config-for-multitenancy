package com.demo.multitenancy.core.domain.model;

import java.util.List;

public record MultiJoinIn<T>(String joinColumn, String joinTable, String inColumn,
                             List<T> joinValues) {

}
